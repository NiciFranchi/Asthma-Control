package edu.gatech.epidemics.dao;

import edu.gatech.epidemics.entities.AgeGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgeGroupRepository extends CrudRepository<AgeGroup, Integer> {
}
