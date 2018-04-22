package edu.gatech.epidemics.fhir;

import ca.uhn.fhir.rest.api.MethodOutcome;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author atalati
 */
public class CarePlan extends FhirBase{
    private String note;
    private List<Activity> activities;

    public CarePlan(String baseUrl) {
        super(baseUrl);
    }

    public CarePlan(String baseUrl, String author, String note, List<Activity> activities) {
        super(baseUrl);
        this.note = note;
        this.activities = activities;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public org.hl7.fhir.dstu3.model.CarePlan getInstance(){
        org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent carePlanActivityComponent;
        org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent carePlanActivityDetailComponent;
        Detail detail;
        for (Activity activity :
                activities) {
            detail = activity.getDetail();
            carePlanActivityComponent = new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent();
            carePlanActivityDetailComponent= new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent();
            carePlanActivityDetailComponent.setStatusReason(detail.getStatusReason());
            carePlanActivityDetailComponent.setDescription(detail.getDescription());
            carePlanActivityComponent.setDetail(carePlanActivityDetailComponent);
        }
        org.hl7.fhir.dstu3.model.CarePlan carePlan = new org.hl7.fhir.dstu3.model.CarePlan();
        carePlan.setStatus(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.ACTIVE);
        carePlan.setIntent(org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.PLAN);
        carePlan.addNote().setText(note);
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
