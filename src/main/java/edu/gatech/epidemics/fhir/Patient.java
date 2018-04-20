package edu.gatech.epidemics.fhir;

import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.gclient.StringClientParam;
import edu.gatech.epidemics.entities.Person;
import org.hl7.fhir.dstu3.model.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author atalati
 */
public class Patient extends FhirBase {
    private String patientId;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String phone;
    private String fax;
    private String email;
    private Date birthday;


    public Patient(String baseUrl) {
        super(baseUrl);
    }

    public Patient(String baseUrl, String patientId, String firstName, String lastName, String city, String state, String phone, String fax, String email, Date birthday) {
        super(baseUrl);
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.birthday = birthday;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    // gets API contract from database entity
    public org.hl7.fhir.dstu3.model.Patient getInstance() {
        org.hl7.fhir.dstu3.model.Patient patient = new org.hl7.fhir.dstu3.model.Patient();
        patient.addIdentifier()
                .setUse(Identifier.IdentifierUse.OFFICIAL)
                .setSystem("SNO")
                .setValue(patientId);
        patient.addName()
                .setUse(HumanName.NameUse.OFFICIAL)
                .setFamily(lastName)
                .addGiven(firstName);
        patient.addTelecom()
                .setSystem(ContactPoint.ContactPointSystem.PHONE)
                .setValue(phone);
        patient.addTelecom()
                .setSystem(ContactPoint.ContactPointSystem.EMAIL)
                .setValue(email);
        patient.addTelecom()
                .setSystem(ContactPoint.ContactPointSystem.FAX)
                .setValue(fax);
        patient.addAddress()
                .setCity(city)
                .setState(state);
        patient.setBirthDate(birthday);
        patient.addCommunication().setLanguage(new CodeableConcept().addCoding(new Coding().setCode("en-US")));
        return patient;
    }

    // gets database entity from API contract
    private Person setInstance(org.hl7.fhir.dstu3.model.Patient patient) {

        if(patient == null){
            return null;
        }

        String firstName;
        String lastName;
        String city;
        String state;
        String phone = "";
        String fax = "";
        String email = "";
        Date birthday;

        HumanName humanName = patient.getNameFirstRep();
        firstName  = humanName.getGivenAsSingleString();
        lastName = humanName.getFamily();

        Address address = patient.getAddressFirstRep();
        city = address.getCity();
        state = address.getState();

        List<ContactPoint> contactPointList= patient.getTelecom();
        for(ContactPoint contactPoint:
                contactPointList){
            if(contactPoint.getUse() == ContactPoint.ContactPointUse.HOME){
                if(contactPoint.getSystem() == ContactPoint.ContactPointSystem.PHONE){
                    phone = contactPoint.getValue();
                }
                else if(contactPoint.getSystem() == ContactPoint.ContactPointSystem.EMAIL){
                    email = contactPoint.getValue();
                }
                else if(contactPoint.getSystem() == ContactPoint.ContactPointSystem.FAX){
                    fax = contactPoint.getValue();
                }
            }
        }

        birthday = patient.getBirthDate();

        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setCity(city);
        person.setState(state);
        person.setContactPhone(phone);
        person.setContactFax(fax);
        person.setContactEmail(email);
        person.setBirthday(birthday);
        return person;
    }

    public String createPatient(org.hl7.fhir.dstu3.model.Patient patient) {
        MethodOutcome request = getClient().create()
                .resource(patient)
                .prettyPrint()
                .encodedJson()
                .execute();

        String patientId = request.getId().getIdPart();
        return patientId;
    }

    // finds a patient from FHIR API for given ID
    public Person findPatient(String id) {
        Person person;
        org.hl7.fhir.dstu3.model.Patient patient = getClient().read()
                .resource(org.hl7.fhir.dstu3.model.Patient.class)
                .withId(id)
                .execute();
        person = setInstance(patient);
        return person;
    }

    // finds all patients from FHIR API for given first name and last name
    public List<Person> findPatients(String firstName, String lastName) {
        Person person;
        org.hl7.fhir.dstu3.model.Patient patient;

        Bundle results = getClient().search()
                .forResource(org.hl7.fhir.dstu3.model.Patient.class)
                .where(new StringClientParam("given").matches().value(firstName))
                .where(new StringClientParam("family").matches().value(lastName))
                .returnBundle(Bundle.class)
                .execute();

        ArrayList<Person> personArrayList = new ArrayList<>();
        for (int i = 0; i < results.getEntry().size() && i < 1; i++) {
            patient = ((org.hl7.fhir.dstu3.model.Patient) results.getEntry().get(i).getResource());
            person = setInstance(patient);
            personArrayList.add(person);
        }
        return personArrayList;
    }
}
