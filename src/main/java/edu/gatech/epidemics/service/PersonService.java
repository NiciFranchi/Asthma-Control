package edu.gatech.epidemics.service;

import edu.gatech.epidemics.dao.PersonRepository;
import edu.gatech.epidemics.entities.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    public List<Person> findAll() {

        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }
    
    public void add(Person person) {
        this.personRepository.save(person);
    }
}
