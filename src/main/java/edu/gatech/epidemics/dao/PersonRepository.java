package edu.gatech.epidemics.dao;

import edu.gatech.epidemics.entities.Person;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByUsername(String userName);
}
