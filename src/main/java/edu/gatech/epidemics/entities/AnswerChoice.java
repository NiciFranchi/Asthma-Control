package edu.gatech.epidemics.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "answer_choice")
public class AnswerChoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer questionId;
    @NotNull
    private Integer answerNumber;
    @NotNull
    private String answerText;

    public AnswerChoice() {
    }

    public AnswerChoice(Integer id, Integer questionId, Integer answerNumber, String answerText) {
        this.id = id;
        this.questionId = questionId;
        this.answerNumber = answerNumber;
        this.answerText = answerText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Integer answerNumber) {
        this.answerNumber = answerNumber;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public String toString() {
        return "AnswerChoice{" + "id=" + id + ", questionId=" + questionId + ", answerNumber=" + answerNumber + ", answerText=" + answerText + '}';
    }
}