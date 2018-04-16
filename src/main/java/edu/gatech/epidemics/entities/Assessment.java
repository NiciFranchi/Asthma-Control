package edu.gatech.epidemics.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "assessment")
public class Assessment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer visitId;
    @NotNull
    private String domainOfControl;
    @NotNull
    private String assessmentLevel;
    @NotNull
    private String treatmentText;

    public Assessment() {
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

    public String getDomainOfControl() {
        return domainOfControl;
    }

    public void setDomainOfControl(String domainOfControl) {
        this.domainOfControl = domainOfControl;
    }

    public String getAssessmentLevel() {
        return assessmentLevel;
    }

    public void setAssessmentLevel(String assessmentLevel) {
        this.assessmentLevel = assessmentLevel;
    }

    public String getTreatmentText() {
        return treatmentText;
    }

    public void setTreatmentText(String treatmentText) {
        this.treatmentText = treatmentText;
    }

    @Override
    public String toString() {
        return "Assessment{" + "id=" + id + ", visitId=" + visitId + ", domainOfControl=" + domainOfControl + ", assessmentLevel=" + assessmentLevel + ", treatmentText=" + treatmentText + '}';
    }
}
