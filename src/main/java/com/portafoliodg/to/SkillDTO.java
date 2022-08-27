package com.portafoliodg.to;

import javax.validation.constraints.NotBlank;

public class SkillDTO {
    @NotBlank
    private String skill;
    private int progress;

    public SkillDTO() {
    }

    public SkillDTO(String skill, int progress) {
        this.skill = skill;
        this.progress = progress;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
    
    
    public int getProgress(){
        return progress;
    }
    
    public void setProgress(int progress){
        this.progress = progress;
    }
    
}
