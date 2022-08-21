package com.portafoliodg.Interface;

import com.portafoliodg.Entity.Skill;
import java.util.List;

public interface ISkill {
    
    public List<Skill> getSkills();
    
    public Skill getSkillById(Long id);
    
    public void saveSkill(Skill skill);
    
    public void deleteSkill(Long id);
    
    public boolean editSkill(Long id, Skill skill);
    
}
