package edu.gatech.epidemics.service;

import edu.gatech.epidemics.dao.AgeGroupRepository;
import edu.gatech.epidemics.entities.AgeGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        AgeGroup ageGroup = findAll().stream()
            .filter(g -> age >= g.getMinAge() && age <= g.getMaxAge())
            .findFirst()
            .orElseGet(() -> null);
        return ageGroup;
    }
    
    public void add(AgeGroup ageGroup) {
        ageGroupRepository.save(ageGroup);
    }
}
