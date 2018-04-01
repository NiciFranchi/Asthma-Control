package edu.gatech.epidemics.viewmodel;

import java.util.List;

/**
 * @author atalati
 */
public class Answers {
    private int patiendId;
    private List<String> answers;

    public Answers() {
    }

    public Answers(int patiendId, List<String> answers) {
        this.patiendId = patiendId;
        this.answers = answers;
    }

    public int getPatiendId() {
        return patiendId;
    }

    public void setPatiendId(int patiendId) {
        this.patiendId = patiendId;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
