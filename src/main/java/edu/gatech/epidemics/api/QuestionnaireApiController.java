package edu.gatech.epidemics.api;

import edu.gatech.epidemics.AppConfigBean;
import edu.gatech.epidemics.entities.Question;
import edu.gatech.epidemics.entities.Response;
import edu.gatech.epidemics.entities.Visit;
import edu.gatech.epidemics.fhir.QuestionComponent;
import edu.gatech.epidemics.fhir.Answers;
import edu.gatech.epidemics.fhir.Questions;
import edu.gatech.epidemics.service.VisitService;
import org.hl7.fhir.dstu3.model.Questionnaire;
import org.hl7.fhir.dstu3.model.QuestionnaireResponse;
import org.hl7.fhir.dstu3.model.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author atalati
 */
@RestController
public class QuestionnaireApiController {

    @Autowired
    private VisitService visitService;

    @Autowired
    AppConfigBean appConfigBean;

    Questions questions;
    Answers answers;
    QuestionComponent questionComponent;


    @PostMapping(value = "/api/fhir/questionnaire", params = "visitId", produces = "application/json")
    public List<String> createQuestionnaireFhirResource(@RequestParam("visitId") Integer visitId) {
        Optional<Visit> visit = visitService.findById(visitId);

        if(!visit.isPresent()){
            return Collections.emptyList();
        }

        String linkId;
        Question question;
        String questionnaireId;
        String questionnaireResponseId;
        String ageGroupText = null;
        List<Questionnaire.QuestionnaireItemComponent> questionnaireItemComponentList = new ArrayList<>();

        QuestionnaireResponse questionnaireResponse = new QuestionnaireResponse();
        for (Response response:
                visit.get().getResponses()) {

            question = response.getQuestion();
            questionComponent = new QuestionComponent();
            linkId = String.format("ag%d_%d", question.getAgeGroup().getId(), question.getQuestionNumber());

            if(ageGroupText == null){
                ageGroupText = question.getAgeGroup().getDescription();
            }

            // questionnaireItemComponentList
            questionComponent.setLinkId(linkId);
            questionComponent.setQuestionText(question.getQuestionText());
            questionnaireItemComponentList.add(questionComponent.getInstance());

            // answers
            questionnaireResponse
                    .addItem()
                    .setLinkId(linkId)
                    .addAnswer()
                    .setValue(new StringType(response.getAnswer().getAnswerText()));
        }

        // Questionnaire
        questions = new Questions(appConfigBean.getFhir_baseUrl(), new Date(), questionnaireItemComponentList, ageGroupText, "Asthma Control Assessment: " + ageGroupText);
        Questionnaire questionnaire = questions.getInstance();
        questionnaireId = questions.createQuestionnaire(questionnaire);

        // Questionnaire Response
        answers = new Answers(appConfigBean.getFhir_baseUrl());
        questionnaireResponseId = answers.createQuestionnaireResponse(questionnaireId, questionnaireResponse);

        List<String> response = new ArrayList<>();
        response.add(String.format("%s/Questionnaire/%s", appConfigBean.getFhir_baseUrl(), questionnaireId));
        response.add(String.format("%s/QuestionnaireResponse/%s", appConfigBean.getFhir_baseUrl(), questionnaireResponseId));

        return response;
    }
}
