package edu.gatech.epidemics.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "response")
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer visitId;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "answer_id")
    private AnswerChoice answer;

    public Response() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public AnswerChoice getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerChoice answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Response{" + "id=" + id + ", visitId=" + visitId + ", question=" + question + ", answer=" + answer + '}';
    }
}
