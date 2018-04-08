package edu.gatech.epidemics.dao;

import edu.gatech.epidemics.entities.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Integer> {
}
