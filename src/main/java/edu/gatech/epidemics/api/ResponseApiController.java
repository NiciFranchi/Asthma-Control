package edu.gatech.epidemics.api;

import edu.gatech.epidemics.dao.VisitRepository;
import edu.gatech.epidemics.entities.Response;
import edu.gatech.epidemics.entities.Visit;
import edu.gatech.epidemics.service.ResponseService;

import java.util.*;

import edu.gatech.epidemics.service.VisitService;
import edu.gatech.epidemics.viewmodel.QuestionAnswer;
import edu.gatech.epidemics.viewmodel.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseApiController {

    @Autowired
    private VisitService visitService;

    @Autowired
    private ResponseService responseService;
    
    @GetMapping(value = "/api/response")
    public List<Response> get() {
        return responseService.findAll();
    }
    
    @GetMapping(value = "/api/response/{id}")
    public Response get(@PathVariable int id) {
        Optional<Response> response = responseService.findById(id);
        return response.get();
    }
    
    @PostMapping(path = "/api/responses", consumes = "application/json")
    public void addResponse(@RequestBody Responses responses) {
        Visit visit = new Visit(responses.getPatientId(), new Date());
        visit = visitService.add(visit);

        List<Response> responseList = new ArrayList<Response>();

        for (QuestionAnswer qa:
             responses.getQuestionAnswers()) {
            responseList.add(new Response(
                    visit.getId(),
                    qa.getQuestionId(),
                    qa.getAnswerId()
            ));
        }
        responseService.addAll(responseList);
    }
}
