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
    private Integer questionId;
    @NotNull
    private Integer answerId;

    public Response() {
    }

    public Response(@NotNull Integer visitId, @NotNull Integer questionId, @NotNull Integer answerId) {
        this.visitId = visitId;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", visitId=" + visitId +
                ", questionId=" + questionId +
                ", answerId=" + answerId +
                '}';
    }
}
