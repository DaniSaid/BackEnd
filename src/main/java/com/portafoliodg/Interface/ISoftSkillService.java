package com.portafoliodg.Interface;

import com.portafoliodg.Model.SoftSkill;
import java.util.List;

public interface ISoftSkillService {
    public List<SoftSkill> getSoftSkills();
    
    public void saveSoftSkill(SoftSkill skill);
    
    public SoftSkill findSoftSkill(Long id);
    
    public void deleteSoftSkill(Long id);
}
