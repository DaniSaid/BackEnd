package com.portafoliodg.to;

import javax.validation.constraints.NotBlank;

public class SkillDTO {
    @NotBlank
    private String Skill;

    public SkillDTO() {
    }

    public SkillDTO(String Skill) {
        this.Skill = Skill;
    }

    public String getSkill() {
        return Skill;
    }

    public void setSkill(String Skill) {
        this.Skill = Skill;
    }
    
    
}
