package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.Response;
import edu.gatech.epidemics.service.ResponseService;
import java.util.List;
import java.util.Optional;

import edu.gatech.epidemics.viewmodel.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseApiController {
    @Autowired
    Environment environment;
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
    
    @PostMapping(path = "/api/responses", consumes = "application/json", produces = "application/json")
    public void addResponse(@RequestBody Responses response) {
        System.out.println(response);
    }
}
