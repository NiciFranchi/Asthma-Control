package edu.gatech.epidemics.api;

import edu.gatech.epidemics.AppConfigBean;
import edu.gatech.epidemics.entities.Person;
import edu.gatech.epidemics.entities.Visit;
import edu.gatech.epidemics.fhir.Patient;
import edu.gatech.epidemics.service.PersonService;
import edu.gatech.epidemics.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author atalati
 */
@RestController
public class PatientApiController {

    @Autowired
    AppConfigBean appConfigBean;
    @Autowired
    private VisitService visitService;
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/api/fhir/patient", params = {"firstName", "lastName"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Person> findPatients(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        List<Person> people = new Patient(appConfigBean.getFhir_baseUrl()).findPatients(firstName, lastName);
        return people;
    }

    @GetMapping(value = "/api/fhir/patient/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person findPatient(@PathVariable String id) {
        System.out.println("Finding patient ID: " + id);
        Person person = new Patient(appConfigBean.getFhir_baseUrl()).findPatient(id);
        return person;
    }


    @PostMapping(value = "/api/fhir/patient/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String createPatientFhirResource(@PathVariable Integer id) {

        Optional<Person> p = personService.findById(id);

        if (!p.isPresent()) {
            return null;
        }

        Person person = p.get();
        String patientId = null;

        Patient patient = new Patient(
                appConfigBean.getFhir_baseUrl(),
                person.getId().toString(),
                person.getFirstName(),
                person.getLastName(),
                person.getCity(),
                person.getState(),
                person.getContactPhone(),
                person.getContactFax(),
                person.getContactEmail(),
                person.getBirthday());

        org.hl7.fhir.dstu3.model.Patient patient1 = patient.getInstance();
        patientId = patient.createPatient(patient1);

        String response = String.format("%s/Patient/%s", appConfigBean.getFhir_baseUrl(), patientId);
        return response;
    }

    @PostMapping(value = "/api/fhir/patient", params = "visitId", produces = MediaType.TEXT_PLAIN_VALUE)
    public String createPatientFhirResourceByVisitId(@RequestParam("visitId") Integer visitId) {
        Optional<Visit> visit = visitService.findById(visitId);

        if (!visit.isPresent()) {
            return null;
        }

        int personId = visit.get().getPatientId();
        return createPatientFhirResource(personId);
    }
}
