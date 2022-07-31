package com.portafoliodg.Service;


import com.portafoliodg.Interface.ISoftSkillService;
import com.portafoliodg.Model.SoftSkill;
import com.portafoliodg.Repository.ISoftSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpSoftSkillService implements ISoftSkillService{
    
    @Autowired ISoftSkillRepository iskillRepository;

    @Override
    public List<SoftSkill> getSoftSkills() {
        List<SoftSkill> skill = iskillRepository.findAll();
        return skill;
    }

    @Override
    public void saveSoftSkill(SoftSkill skill) {
        iskillRepository.save(skill);   
    }

    @Override
    public SoftSkill findSoftSkill(Long id) {
        SoftSkill skill = iskillRepository.findById(id).orElse(null);
        return skill;
    }

    @Override
    public void deleteSoftSkill(Long id) {
        iskillRepository.deleteById(id);
    }    
   
}
