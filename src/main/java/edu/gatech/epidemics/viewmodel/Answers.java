package edu.gatech.epidemics.viewmodel;

/**
 * @author atalati
 */
public class Answers {
    private int patientId;
    private String answers;

    public Answers() {
    }

    public Answers(int patientId, String answers) {
        this.patientId = patientId;
        this.answers = answers;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "patientId=" + patientId +
                ", answers='" + answers + '\'' +
                '}';
    }
}
