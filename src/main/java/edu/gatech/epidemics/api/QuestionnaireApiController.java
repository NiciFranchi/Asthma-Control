package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.Person;
import edu.gatech.epidemics.entities.Question;
import edu.gatech.epidemics.service.QuestionService;
import edu.gatech.epidemics.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author atalati
 */
@RestController
public class QuestionnaireApiController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/api/questionnaire/{id}")
    /*
        This endpoint automatically returns questionnaire for a givend patient
     */
    public List<Question> get(@PathVariable int id) {
        Optional<Person> person = personService.findById(id);
        int age = person.get().getAge();
        return questionService.findByAge(age);
    }
}
