package edu.gatech.epidemics.service;

import edu.gatech.epidemics.dao.AnswerChoiceRepository;
import edu.gatech.epidemics.entities.AnswerChoice;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerChoiceService {
    @Autowired
    private final AnswerChoiceRepository answerChoiceRepository;
    
    public AnswerChoiceService(AnswerChoiceRepository answerChoiceRepository) {
        this.answerChoiceRepository = answerChoiceRepository;
    }
    
    public List<AnswerChoice> findAll() {

        List<AnswerChoice> answerChoices = new ArrayList<>();
        answerChoiceRepository.findAll().forEach(answerChoices::add);
        return answerChoices;
    }
    
    public Optional<AnswerChoice> findById(Integer id) {
        return answerChoiceRepository.findById(id);
    }
    
    public void add(AnswerChoice question) {
        answerChoiceRepository.save(question);
    }
}
