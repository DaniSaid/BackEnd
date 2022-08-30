package com.portafoliodg.Interface;

import com.portafoliodg.Entity.Education;
import java.util.List;
import java.util.Optional;

public interface IEducation {
    
    public List<Education> getEducationList();
    
    public void saveEducation(Education edu);
    
    public void deleteEducation(Long id);
    
    public Optional<Education> getEducationById(Long id);
    
    public boolean eduExistsById(Long id);
}
