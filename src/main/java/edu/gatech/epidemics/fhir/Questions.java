package edu.gatech.epidemics.fhir;

import ca.uhn.fhir.rest.api.MethodOutcome;
import org.hl7.fhir.dstu3.model.Enumerations;
import org.hl7.fhir.dstu3.model.Questionnaire;

import java.util.Date;
import java.util.List;

/**
 * @author atalati
 */

public class Questions extends FhirBase {

    private Date date;
    private List<Questionnaire.QuestionnaireItemComponent> questionnaireItemComponentList;
    private String title;
    private String description;

    public Questions(String baseUrl) {
        super(baseUrl);
    }

    public Questions(String baseUrl, Date date, List<Questionnaire.QuestionnaireItemComponent> questionnaireItemComponentList, String title, String description) {
        super(baseUrl);
        this.date = date;
        this.questionnaireItemComponentList = questionnaireItemComponentList;
        this.title = title;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Questionnaire.QuestionnaireItemComponent> getQuestionnaireItemComponentList() {
        return questionnaireItemComponentList;
    }

    public void setQuestionnaireItemComponentList(List<Questionnaire.QuestionnaireItemComponent> questionnaireItemComponentList) {
        this.questionnaireItemComponentList = questionnaireItemComponentList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Questionnaire getInstance(){
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setDate(date);
        questionnaire.setTitle(title);
        questionnaire.setStatus(Enumerations.PublicationStatus.ACTIVE);
        questionnaire.setPublisher("Aarsh Talati");
        questionnaire.setDescription(description);
        for (Questionnaire.QuestionnaireItemComponent question:
                questionnaireItemComponentList) {
            questionnaire.addItem(question);
        }
        return questionnaire;
    }

    public String createQuestionnaire(Questionnaire questionnaire){
        MethodOutcome request = getClient().create()
                .resource(questionnaire)
                .prettyPrint()
                .encodedJson()
                .execute();

        String questionnaireId = request.getId().getIdPart();
        return questionnaireId;
    }
}
