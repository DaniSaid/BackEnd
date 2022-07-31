package com.portafoliodg.Service;

import com.portafoliodg.Interface.IEducationService;
import com.portafoliodg.Model.Education;
import com.portafoliodg.Repository.IEducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpEducationService implements IEducationService{
    
    @Autowired
    IEducationRepository ieducationRepository;
    
    @Override
    public List<Education> getEducation() {
        List<Education> education = ieducationRepository.findAll();
        return education;
    }

    @Override
    public void saveEducation(Education education) {
        ieducationRepository.save(education);
    }

    @Override
    public Education findEducation(Long id) {
        
        Education education = ieducationRepository.findById(id).orElse(null);
        return education;
    }

    @Override
    public void deleteEducation(Long id) {
        ieducationRepository.deleteById(id);
    }
    
}
