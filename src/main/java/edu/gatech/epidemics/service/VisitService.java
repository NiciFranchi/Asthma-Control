package edu.gatech.epidemics.service;

import edu.gatech.epidemics.dao.VisitRepository;
import edu.gatech.epidemics.entities.Visit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    @Autowired
    private final VisitRepository visitRepository;
    
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }
    
    public List<Visit> findAll() {

        List<Visit> visits = new ArrayList<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }
    
    public Optional<Visit> findById(Integer id) {
        return visitRepository.findById(id);
    }
    
    public Visit add(Visit visit) {
        return visitRepository.save(visit);
    }
}
