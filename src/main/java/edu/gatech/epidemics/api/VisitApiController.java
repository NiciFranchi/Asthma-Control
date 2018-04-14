package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.Visit;
import edu.gatech.epidemics.service.VisitService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitApiController {
    @Autowired
    Environment environment;
    @Autowired
    private VisitService visitService;
    
    @GetMapping(value = "/api/visit")
    public List<Visit> get() {
        return visitService.findAll();
    }
    
    @GetMapping(value = "/api/visit/{id}")
    public Visit get(@PathVariable int id) {
        Optional<Visit> visit = visitService.findById(id);
        return visit.get();
    }
    
    @PostMapping(path = "/api/visit", consumes = "application/json", produces = "application/json")
    public void addVisit(@RequestBody Visit visit) {
        visitService.add(visit);
    }
}
