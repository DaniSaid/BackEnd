package com.portafoliodg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String skill;

    public Skill() {
    }

    public Skill(Long id, String skill) {
        this.id = id;
        this.skill = skill;
    }
    
    
}