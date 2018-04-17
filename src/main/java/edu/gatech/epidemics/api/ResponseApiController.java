package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.Response;
import edu.gatech.epidemics.service.ResponseService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseApiController {

    @Autowired
    private ResponseService responseService;
    
    @GetMapping(value = "/api/responses")
    public List<Response> get() {
        return responseService.findAll();
    }
    
    @GetMapping(value = "/api/responses/{id}")
    public Response get(@PathVariable int id) {
        Optional<Response> response = responseService.findById(id);
        return response.get();
    }
    
    @PostMapping(path = "/api/responses", consumes = "application/json")
    public void addResponse(@RequestBody Response response) {
        responseService.add(response);
    }
}
