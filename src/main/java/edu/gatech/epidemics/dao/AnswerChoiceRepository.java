package edu.gatech.epidemics.dao;

import edu.gatech.epidemics.entities.AnswerChoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerChoiceRepository extends CrudRepository<AnswerChoice, Integer> {
}
