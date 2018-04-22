package edu.gatech.epidemics.fhir;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;

/**
 * @author atalati
 */
@JsonDeserialize
public class Detail implements Serializable {
    private String statusReason;
    private String description;

    public Detail() {
    }

    public Detail(String statusReason, String description) {
        this.statusReason = statusReason;
        this.description = description;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
