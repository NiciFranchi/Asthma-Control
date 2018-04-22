package edu.gatech.epidemics.fhir;

import java.util.List;

/**
 * @author atalati
 */
public class Detail {
    private String statusReason;
    private String description;
    private List<String> performer;

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

    public List<String> getPerformer() {
        return performer;
    }

    public void setPerformer(List<String> performer) {
        this.performer = performer;
    }
}
