package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.Person;
import edu.gatech.epidemics.service.PersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping(value = "/api/person/{id}")
    public Person get(@PathVariable int id) {
        Optional<Person> person = personService.findById(id);
        return person.get();
    }
    
    @RequestMapping(value = "/api/person", params = "username")
    public List<Person> findByUsername(@RequestParam("username") String username) {
        return personService.findByUsername(username);
    }
    
    @PostMapping(path = "/api/person", consumes = "application/json", produces = "application/json")
    public void addPerson(@RequestBody Person person) {
        personService.add(person);
    }
}
