package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.Person;
import edu.gatech.epidemics.entities.PersonType;
import edu.gatech.epidemics.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonApiController {
    
    @Autowired
    Environment environment;
    @Autowired
    private PersonService personService;
    
    @GetMapping(value = "/api/person")
    public List<Person> get() {
        return personService.findAll();
    }
    
    @GetMapping(value = "/api/person/addExample")
    public String addExample() {
        Person person = new Person();
        person.setActive(Boolean.TRUE);
        person.setAddressLine1("Address Line1");
        person.setAddressLine2("Address Line2");
        person.setCity("Atlanta");
        person.setContactEmail("email@test.com");
        person.setContactFax("555-555-5556");
        person.setContactPhone("555-555-5555");
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setMiddleName("M.");
        person.setPassword("test");
        person.setPersonType(PersonType.PATIENT);
        person.setState("Georgia");
        person.setUsername("john");
        person.setZip("12345");
        personService.add(person);
        return "added";
    }
}
