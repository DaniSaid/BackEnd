package com.portafoliodg.Interface;

import com.portafoliodg.Entity.Experience;
import java.util.List;
import java.util.Optional;

public interface IExperience {
    public List<Experience> getExperiences();
    
    public Optional<Experience> getExpById(Long id);
    
    public void saveExp(Experience exp);
    
    public void deleteExp(Long id);
    
    public boolean expExistsById(Long id);
}
