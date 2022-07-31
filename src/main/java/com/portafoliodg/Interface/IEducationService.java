package com.portafoliodg.Interface;

import com.portafoliodg.Model.Education;
import java.util.List;

public interface IEducationService {
    
    public List<Education> getEducation();
    
    public void saveEducation(Education education);
    
    public Education findEducation(Long id);
    
    public void deleteEducation(Long id);
    
}
