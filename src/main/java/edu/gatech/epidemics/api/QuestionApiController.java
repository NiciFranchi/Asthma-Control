package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.Question;
import edu.gatech.epidemics.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionApiController {

    @Autowired
    Environment environment;
    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "/api/questions")
    public List<Question> get() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (obj instanceof UserDetails) {
            username = ((UserDetails) obj).getUsername();
        } else {
            username = obj.toString();
        }
        return questionService.findAll();
    }

    @GetMapping(value = "/api/questions/{id}")
    public Question get(@PathVariable int id) {
        Optional<Question> question = questionService.findById(id);
        return question.get();
    }

    @RequestMapping(value = "/api/questions", params = "age")
    public List<Question> findByAge(@RequestParam("age") Integer age) {
        return questionService.findByAge(age);
    }

    @PostMapping(path = "/api/questions", consumes = "application/json", produces = "application/json")
    public void addQuestion(@RequestBody Question question) {
        questionService.add(question);
    }

//    @GetMapping(value = "/api/questionnaire")
//    public List<Question> get() {
//        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = null;
//        if (obj instanceof UserDetails) {
//            username = ((UserDetails) obj).getUsername();
//        } else {
//            username = obj.toString();
//        }
//    }
}
