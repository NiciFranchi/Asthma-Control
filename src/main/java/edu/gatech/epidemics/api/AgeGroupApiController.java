package edu.gatech.epidemics.api;

import edu.gatech.epidemics.entities.AgeGroup;
import edu.gatech.epidemics.service.AgeGroupService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeGroupApiController {
    
    @Autowired
    Environment environment;
    @Autowired
    private AgeGroupService ageGroupService;
    
    @GetMapping(value = "/api/age-groups")
    public List<AgeGroup> get() {
        return ageGroupService.findAll();
    }
    
    @GetMapping(value = "/api/age-groups/{id}")
    public AgeGroup get(@PathVariable int id) {
        Optional<AgeGroup> ageGroup = ageGroupService.findById(id);
        return ageGroup.get();
    }
    
    @RequestMapping(value = "/api/age-groups", params = "age")
    public List<AgeGroup> findByAge(@RequestParam("age") Integer age) {
        return ageGroupService.findByAge(age);
    }
    
    @PostMapping(path = "/api/age-groups", consumes = "application/json", produces = "application/json")
    public void addAgeGroup(@RequestBody AgeGroup ageGroup) {
        ageGroupService.add(ageGroup);
    }
}