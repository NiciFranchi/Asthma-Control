package edu.gatech.epidemics.service;

import edu.gatech.epidemics.dao.ResponseRepository;
import edu.gatech.epidemics.entities.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    @Autowired
    private final ResponseRepository responseRepository;

    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }
    
    public List<Response> findAll() {

        List<Response> responses = new ArrayList<>();
        responseRepository.findAll().forEach(responses::add);
        return responses;
    }
    
    public Optional<Response> findById(Integer id) {
        return responseRepository.findById(id);
    }
    
    public Response add(Response response) {
        return responseRepository.save(response);
    }

    public Iterable<Response> addAll(Iterable<Response> responses)
    {
        return responseRepository.saveAll(responses);
    }
}
