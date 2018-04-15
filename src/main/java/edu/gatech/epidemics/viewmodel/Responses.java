package edu.gatech.epidemics.viewmodel;

/**
 * @author atalati
 */
public class Responses {
    private int patientId;
    private QuestionAnswer[] questionAnswers;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public QuestionAnswer[] getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(QuestionAnswer[] questionAnswers) {
        this.questionAnswers = questionAnswers;
    }
}
