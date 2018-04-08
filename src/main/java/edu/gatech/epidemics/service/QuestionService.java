package edu.gatech.epidemics.service;

import edu.gatech.epidemics.dao.QuestionRepository;
import edu.gatech.epidemics.entities.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private final QuestionRepository questionRepository;
    
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    
    public List<Question> findAll() {

        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        return questions;
    }
    
    public Optional<Question> findById(Integer id) {
        return questionRepository.findById(id);
    }
    
    public List<Question> findByAge(Integer age) {
        
        return findAll().stream()
            .filter(q -> age >= q.getAgeGroup().getMinAge() && age <= q.getAgeGroup().getMaxAge())
            .collect(Collectors.toList());
    }
    
    public void add(Question question) {
        questionRepository.save(question);
    }
}
