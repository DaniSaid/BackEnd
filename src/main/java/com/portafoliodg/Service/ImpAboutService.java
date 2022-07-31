package com.portafoliodg.Service;

import com.portafoliodg.Interface.IAboutService;
import com.portafoliodg.Model.About;
import com.portafoliodg.Repository.IAboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpAboutService implements IAboutService{
    
    @Autowired
    IAboutRepository iaboutRepository;

    @Override
    public List<About> getAbout() {
        
        List<About> about = iaboutRepository.findAll();
        return about;
    }

    @Override
    public void saveAbout(About about) {
        
        iaboutRepository.save(about);
    }

    @Override
    public About findAbout(Long id) {
        
        About about = iaboutRepository.findById(id).orElse(null);
        return about;
    }
    
    @Override
    public void deleteAbout(Long id) {
        
        iaboutRepository.deleteById(id);
    }
    
}
