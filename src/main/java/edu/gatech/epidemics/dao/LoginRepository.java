package edu.gatech.epidemics.dao;

import edu.gatech.epidemics.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author atalati
 */
public interface LoginRepository extends JpaRepository<Person, Integer> {
    Person findByUserName(String usernme);
}
