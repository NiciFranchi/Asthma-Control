package edu.gatech.epidemics.service;

import edu.gatech.epidemics.dao.AgeGroupRepository;
import edu.gatech.epidemics.entities.AgeGroup;
import edu.gatech.epidemics.entities.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgeGroupService {
    @Autowired
    private final AgeGroupRepository ageGroupRepository;
    
    public AgeGroupService(AgeGroupRepository ageGroupRepository) {
        this.ageGroupRepository = ageGroupRepository;
    }
    
    public List<AgeGroup> findAll() {

        List<AgeGroup> ageGroups = new ArrayList<>();
        ageGroupRepository.findAll().forEach(ageGroups::add);
        return ageGroups;
    }
    
    public Optional<AgeGroup> findById(Integer id) {
        return ageGroupRepository.findById(id);
    }
    
    public AgeGroup findByAge(Integer age) {
        
        List<AgeGroup> ageGroups = findAll().stream()
            .filter(g -> age >= g.getMinAge() && age <= g.getMaxAge())
            .collect(Collectors.toList());
        return ageGroups.get(0);
    }
    
    public void add(AgeGroup ageGroup) {
        this.ageGroupRepository.save(ageGroup);
    }
    
    public Set<Question> getQuestions(Integer id) {
        Optional<AgeGroup> ageGroup = findById(id);
        return ageGroup.get().getQuestions();
    }
}
