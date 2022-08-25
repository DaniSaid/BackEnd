package com.portafoliodg.Interface;

import com.portafoliodg.Entity.Skill;
import java.util.List;
import java.util.Optional;

public interface ISkill {
    
    public List<Skill> getSkillList();
    
    public Optional<Skill> getSkillById(Long id);
    
    public void saveSkill(Skill skill);
    
    public void deleteSkill(Long id);
   
    public boolean skillExistsById(Long id);
}
