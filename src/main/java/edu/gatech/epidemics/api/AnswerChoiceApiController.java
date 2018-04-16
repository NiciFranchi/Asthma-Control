package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.AnswerChoice;
import edu.gatech.epidemics.service.AnswerChoiceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerChoiceApiController {
    @Autowired
    Environment environment;
    @Autowired
    private AnswerChoiceService answerService;
    
    @GetMapping(value = "/api/answer-choices")
    public List<AnswerChoice> get() {
        return answerService.findAll();
    }
    
    @GetMapping(value = "/api/answer-choices/{id}")
    public AnswerChoice get(@PathVariable int id) {
        Optional<AnswerChoice> answerChoice = answerService.findById(id);
        return answerChoice.get();
    }
    
    @PostMapping(path = "/api/answer-choices", consumes = "application/json", produces = "application/json")
    public void addAnswerChoice(@RequestBody AnswerChoice answerChoice) {
        answerService.add(answerChoice);
    }
}
