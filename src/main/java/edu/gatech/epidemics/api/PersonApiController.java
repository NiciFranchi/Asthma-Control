package edu.gatech.epidemics.api;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.SimpleRestrictionModel;
import edu.gatech.epidemics.dao.ResponseRepository;
import edu.gatech.epidemics.entities.Person;
import edu.gatech.epidemics.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonApiController {
    
    @Autowired
    Environment environment;
    @Autowired
    private PersonService personService;
    
    @GetMapping(value = "/api/persons")
    public List<Person> get() {
        return personService.findAll();
    }
    
    @GetMapping(value = "/api/persons/{id}")
    public Person get(@PathVariable int id) {
        Person person;
        
        if (id == 0) {
            person = new Person();
        } else {
            person = personService.findById(id).get();
        }
        
        return person;
    }
    
    @RequestMapping(value = "/api/persons", params = "username")
    public List<Person> findByUsername(@RequestParam("username") String username) {
        return personService.findByUsername(username);
    }
    
    @PostMapping(path = "/api/persons", consumes = "application/json", produces = "application/json")
    public Person addPerson(@RequestBody Person person) {
        return personService.add(person);
    }

    @DeleteMapping(path = "/api/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletePerson(@PathVariable int id){
        try {
            personService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
