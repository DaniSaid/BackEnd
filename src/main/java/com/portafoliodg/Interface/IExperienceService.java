package com.portafoliodg.Interface;

import com.portafoliodg.Model.Experience;
import java.util.List;

public interface IExperienceService {
    public List<Experience> getExperience();
    
    public void saveExperience(Experience exp);
    
    public Experience findExperience(Long id);
    
    public void deleteExperience(Long id);
}
