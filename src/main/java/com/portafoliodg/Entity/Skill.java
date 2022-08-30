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
    private int progress;

    public Skill() {
    }

    public Skill(String skill, int progress) {
       
        this.skill = skill;
        this.progress = progress;
    }
    
    
}