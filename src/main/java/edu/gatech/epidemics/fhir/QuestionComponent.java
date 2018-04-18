package edu.gatech.epidemics.fhir;

import org.hl7.fhir.dstu3.model.Questionnaire;
import org.springframework.stereotype.Service;

/**
 * @author atalati
 */
public class QuestionComponent {
    private String linkId;
    private String questionText;

    public QuestionComponent() {
    }

    public QuestionComponent(String linkId, String questionText) {
        this.linkId = linkId;
        this.questionText = questionText;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Questionnaire.QuestionnaireItemComponent getInstance(){
        Questionnaire.QuestionnaireItemComponent questionnaireItemComponent = new Questionnaire.QuestionnaireItemComponent();
        questionnaireItemComponent.setLinkId(linkId);
        questionnaireItemComponent.setText(questionText);
        questionnaireItemComponent.setType(Questionnaire.QuestionnaireItemType.DISPLAY);
        questionnaireItemComponent.setRequired(true);
        questionnaireItemComponent.setRepeats(false);
        questionnaireItemComponent.setReadOnly(false);
        // questionnaireItemComponent.setMaxLength(1000);
        questionnaireItemComponent.setType(Questionnaire.QuestionnaireItemType.CHOICE);
        return questionnaireItemComponent;
    }
}
