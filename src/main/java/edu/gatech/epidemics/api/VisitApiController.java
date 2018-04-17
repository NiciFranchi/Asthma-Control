package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.Visit;
import edu.gatech.epidemics.service.VisitService;
import java.util.Date;
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
    
    @GetMapping(value = "/api/visits")
    public List<Visit> get() {
        return visitService.findAll();
    }
    
    @GetMapping(value = "/api/visits/{id}")
    public Visit get(@PathVariable int id) {
        Optional<Visit> visit = visitService.findById(id);
        return visit.get();
    }
    
    @PostMapping(path = "/api/visits", consumes = "application/json", produces = "application/json")
    public Visit addVisit(@RequestBody Visit visit) {
        if (visit.getId() == null) {
            visit.setVisitDate(new Date());
        } else if (!visit.getResponses().isEmpty()) {
            visit.assess();
        }
        return visitService.add(visit);
    }
}
