package edu.gatech.epidemics.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.gatech.epidemics.AppConfigBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author atalati
 */
@JsonDeserialize
public class CarePlanDataContract implements Serializable {
    @JsonProperty("note")
    private String note;
    @JsonProperty("details")
    private List<Detail> details;

    public CarePlanDataContract() {
    }

    public CarePlanDataContract(String note, List<Detail> details) {
        this.note = note;
        this.details = details;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public CarePlan mapper(String fhir_baseUrl){
        CarePlan carePlan = new CarePlan(fhir_baseUrl, this.note, this.details);
        return carePlan;
    }
}
