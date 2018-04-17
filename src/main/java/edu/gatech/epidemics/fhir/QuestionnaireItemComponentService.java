package edu.gatech.epidemics.fhir;

import org.hl7.fhir.dstu3.model.Questionnaire;
import org.springframework.stereotype.Service;

/**
 * @author atalati
 */
@Service
public class QuestionnaireItemComponentService {
    private int ageGroup;
    private int questionIndex;
    private String text;

    public QuestionnaireItemComponentService() {
    }

    public QuestionnaireItemComponentService(int ageGroup, int questionIndex, String text) {
        this.ageGroup = ageGroup;
        this.questionIndex = questionIndex;
        this.text = text;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Questionnaire.QuestionnaireItemComponent getInstance(){
        // String linkId = String.format("ag_%s_%d", ag.replace(" ","").toLowerCase(),i);
        String linkId = String.format("ag_%d_%d", ageGroup, questionIndex);
        Questionnaire.QuestionnaireItemComponent questionnaireItemComponent = new Questionnaire.QuestionnaireItemComponent();
        questionnaireItemComponent.setLinkId(linkId);
        questionnaireItemComponent.setText(text);
        questionnaireItemComponent.setType(Questionnaire.QuestionnaireItemType.DISPLAY);
        questionnaireItemComponent.setRequired(true);
        questionnaireItemComponent.setRepeats(false);
        questionnaireItemComponent.setReadOnly(false);
        questionnaireItemComponent.setMaxLength(1000);
        questionnaireItemComponent.setType(Questionnaire.QuestionnaireItemType.CHOICE);
        return questionnaireItemComponent;
    }
}
