package edu.gatech.epidemics.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.gatech.epidemics.AppConfigBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author atalati
 */
public class CarePlan extends FhirBase{
    private String note;
    private List<Detail> details;

    public CarePlan(String baseUrl) {
        super(baseUrl);
    }

    public CarePlan(String baseUrl, String note, List<Detail> details) {
        super(baseUrl);
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

    public org.hl7.fhir.dstu3.model.CarePlan getInstance(){
        List<org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent> carePlanActivityComponents= new ArrayList<>();
        org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent carePlanActivityComponent;
        org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent carePlanActivityDetailComponent;
        for (Detail detail:
                details) {
            carePlanActivityComponent = new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent();
            carePlanActivityDetailComponent= new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent();
            carePlanActivityDetailComponent.setStatusReason(detail.getStatusReason());
            carePlanActivityDetailComponent.setDescription(detail.getDescription());
            carePlanActivityComponent.setDetail(carePlanActivityDetailComponent);
            carePlanActivityComponents.add(carePlanActivityComponent);
        }
        org.hl7.fhir.dstu3.model.CarePlan carePlan = new org.hl7.fhir.dstu3.model.CarePlan();
        carePlan.setStatus(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.ACTIVE);
        carePlan.setIntent(org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.PLAN);
        carePlan.addNote().setText(note);
        carePlan.setActivity(carePlanActivityComponents);
        return carePlan;
    }

    public String createCarePlan(org.hl7.fhir.dstu3.model.CarePlan carePlan){
        MethodOutcome request = getClient().create()
                .resource(carePlan)
                .prettyPrint()
                .encodedJson()
                .execute();

        String carePlanId = request.getId().getIdPart();
        return carePlanId;
    }
}
