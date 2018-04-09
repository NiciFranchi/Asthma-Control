package edu.gatech.epidemics.dao;

import edu.gatech.epidemics.entities.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author atalati
 */
@Repository
public interface RoleRepository extends JpaRepository<Authorities, Integer> {
    Authorities findByUsername(String name);
}
