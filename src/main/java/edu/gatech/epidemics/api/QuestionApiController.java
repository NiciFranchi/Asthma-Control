package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.Question;
import edu.gatech.epidemics.service.QuestionService;
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
public class QuestionApiController {
    
    @Autowired
    Environment environment;
    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "/api/questionnaire/{id}")
    public List<Question> get(@PathVariable int id) {
        /**
         * This method takes an integer as an input. This intger represents an id for an age-group.
         * This end-point would retrun questionnaire with appropriate answer choices, depending on the age group.
         *
         * -------------------
         * |Id |	Age Group|
         * -------------------
         * 	1		Infant
         * 	2		Young
         * 	3		Older
         */

        // infant
        Question infantQ1 = new Question(
                1,
                "Asthma symptoms in previous 2 – 4 weeks",
                Arrays.asList("<= days/week", ">2 days/week", "Throughout the day"));
        Question infantQ2 = new Question(
                2,
                "Night time awakenings in previous 2- 4 weeks",
                Arrays.asList("<= 1x/month", "> 1x/month", ">= 1x/week"));
        Question infantQ3 = new Question(
                3,
                "Interference with normal activity in previous 2-4 weeks",
                Arrays.asList("None", "Some Limitation", "Extremely Limited"));
        Question infantQ4 = new Question(
                4,
                "Short-acting \n" +
                        "beta2-agonist use for symptom control in previous 2-4 weeks " +
                        "(not prevention of exercise-induced bronchospasm)\n",
                Arrays.asList("<= 2 days /week", ">2 days/week", "Several times per day"));
        Question infantQ5 = new Question(
                4,
                "Exacerbations requiring oral systemic corticosteroids",
                Arrays.asList("0-1/year", "2-3/year", "> 3/year"));

        Question youngQ1 = new Question(5, "First question for young", Arrays.asList("q1 a1", "q1 a2"));
        Question youngQ2 = new Question(6, "Second question for young", Arrays.asList("q2 a1", "q2 a2", "q2 a3"));
        Question youngQ3 = new Question(7, "Third question for young", Arrays.asList("q4 a1", "q4 a2", "q4 a3", "q4 a4"));

        Question olderQ1 = new Question(8, "First question for older", Arrays.asList("q1 a1", "q1 a2"));
        Question olderQ2 = new Question(9, "Second question for older", Arrays.asList("q2 a1", "q2 a2", "q2 a3"));
        Question olderQ3 = new Question(10, "Third question for older", Arrays.asList("q3 a1", "q3 a2"));
        Question olderQ4 = new Question(11, "Fourth question for older", Arrays.asList("q4 a1", "q4 a2", "q4 a3"));

        List<Question> questions = new ArrayList<Question>();

        if (id == 1) {
            questions.add(infantQ1);
            questions.add(infantQ2);
            questions.add(infantQ3);
            questions.add(infantQ4);
            questions.add(infantQ5);
        } else if (id == 2) {
            questions.add(youngQ1);
            questions.add(youngQ2);
            questions.add(youngQ3);
        } else if (id == 3) {
            questions.add(olderQ1);
            questions.add(olderQ2);
            questions.add(olderQ3);
            questions.add(olderQ4);
        } else {
            questions = null;
        }
        return questions;
    }

    /*
    @GetMapping(value = "/api/questions")
    public List<Question> get() {
        return questionService.findAll();
    }
    */

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

}
