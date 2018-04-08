package edu.gatech.epidemics.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "age_group")
public class AgeGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer minAge;
    @NotNull
    private Integer maxAge;
    @NotNull
    private String description;
    @OneToMany(mappedBy = "ageGroup", cascade = CascadeType.ALL)
    private Set<Question> questions;
    
    public AgeGroup() {
    }

    public AgeGroup(Integer id, Integer minAge, Integer maxAge, String description) {
        this.id = id;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.description = description;
    }

    @Override
    public String toString() {
        return "AgeGroup{" + "id=" + id + ", minAge=" + minAge + ", maxAge=" + maxAge + ", description=" + description + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Question> getQuestions() {
        return questions;
    }
}
