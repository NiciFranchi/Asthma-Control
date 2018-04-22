package edu.gatech.epidemics.api;

import edu.gatech.epidemics.AppConfigBean;
import edu.gatech.epidemics.entities.Person;
import edu.gatech.epidemics.entities.Visit;
import edu.gatech.epidemics.fhir.CarePlan;
import edu.gatech.epidemics.service.PersonService;
import edu.gatech.epidemics.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author atalati
 */
@RestController
public class CarePlanApiController {

    @Autowired
    AppConfigBean appConfigBean;

    @PostMapping(value = "/api/fhir/careplan", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String createPatientFhirResource(@RequestBody CarePlan carePlan) {

        String carePlanId;

        org.hl7.fhir.dstu3.model.CarePlan carePlan1 = carePlan.getInstance();
        carePlanId = carePlan.createCarePlan(carePlan1);

        String response = String.format("%s/Patient/%s", appConfigBean.getFhir_baseUrl(), carePlanId);
        return response;
    }
}
