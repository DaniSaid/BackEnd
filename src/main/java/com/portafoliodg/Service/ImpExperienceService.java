package com.portafoliodg.Service;

import com.portafoliodg.Interface.IExperienceService;
import com.portafoliodg.Model.Experience;
import com.portafoliodg.Repository.IExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpExperienceService implements IExperienceService{

    @Autowired IExperienceRepository iexpRepository;
    
    @Override
    public List<Experience> getExperience() {
        List<Experience> exp = iexpRepository.findAll();
        return exp;
    }

    @Override
    public void saveExperience(Experience exp) {
        iexpRepository.save(exp);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience exp = iexpRepository.findById(id).orElse(null);
        return exp;
    }

    @Override
    public void deleteExperience(Long id) {
        iexpRepository.deleteById(id);
    }
    
}
