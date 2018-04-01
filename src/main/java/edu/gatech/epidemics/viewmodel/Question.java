package edu.gatech.epidemics.viewmodel;

import java.util.List;

/**
 * @author atalati
 * /api/user
 */
public class Question {
    private int id;
    private String questionText;
    private List<String> answerChoices;

    public Question() {
    }

    public Question(int id, String questionText, List<String> answerChoices) {
        this.id = id;
        this.questionText = questionText;
        this.answerChoices = answerChoices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(List<String> answerChoices) {
        this.answerChoices = answerChoices;
    }
}
