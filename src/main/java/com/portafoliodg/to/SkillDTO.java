package com.portafoliodg.to;

import javax.validation.constraints.NotBlank;

public class SkillDTO {
    @NotBlank
    private String skill;
    private int progress;
    private String icon;

    public SkillDTO() {
    }

    public SkillDTO(String skill, int progress, String icon) {
        this.skill = skill;
        this.progress = progress;
        this.icon = icon;
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
    
    public String getIcon(){
        return icon;
    }
    public void setIcon(){
        this.icon = icon;
    }
    
}
