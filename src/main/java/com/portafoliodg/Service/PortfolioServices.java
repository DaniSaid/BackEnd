package com.portafoliodg.Service;

import com.portafoliodg.Entity.About;
import com.portafoliodg.Repository.AboutRepository;
import com.portafoliodg.to.Portfolio;
import com.portafoliodg.to.State;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServices {
    
    @Autowired AboutRepository aboutRepo;
    
    public List<About> getAbout(){
		List<About> about = aboutRepo.findAll();
                
                return about;
	}
    
    public void saveAbout(About about){
        aboutRepo.save(about);
    }
    
    public About findAbout(Long id){
        About about = aboutRepo.findById(id).orElse(null);
        
        return about;
    }
    
    public Portfolio getPortfolio(long aboutId){
        //recupera los datos de about desde el repositorio(la persistencia)
        About about = aboutRepo.findById(aboutId).orElse(null);
        
        
        //manda la info al portfolio
        Portfolio portfolio = new Portfolio();
        portfolio.setAbout(about);
        //queda agregar los demas componentes
        
        return portfolio;
        
    }
    
    public void deleteAbout(Long id){
       
        aboutRepo.deleteById(id);
        
    }
    
    //mensajes de alta o error
    public State updateAboutData(About about){
        if (about !=null && aboutRepo.existsById(about.getId())) {
            aboutRepo.save(about);
            
            return new State(true, "perfil Actualizado");
        }
        
        return new State(false, "no se puedo actualizar el perfil");
    }
    
}
