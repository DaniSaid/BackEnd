package com.portafoliodg.Service;

import com.portafoliodg.Entity.About;
import com.portafoliodg.Entity.Tool;
import com.portafoliodg.Interface.ITool;
import com.portafoliodg.Repository.AboutRepository;
import com.portafoliodg.Repository.ToolRepository;
import com.portafoliodg.to.Portfolio;
import com.portafoliodg.to.State;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServices implements ITool{
    
    @Autowired AboutRepository aboutRepo;
    @Autowired ToolRepository toolRepo;
    
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
    
    public void deleteAbout(Long id){
       
        aboutRepo.deleteById(id);
        
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
    
    //mensajes de alta o error
    public State updateAboutData(About about){
        if (about !=null && aboutRepo.existsById(about.getId())) {
            aboutRepo.save(about);
            
            return new State(true, "perfil Actualizado");
        }
        
        return new State(false, "no se puedo actualizar el perfil");
    }
    
    //-------------implementacion de metodos  Tool--------------------

    @Override
    public List<Tool> getTool() {
        return toolRepo.findAll();
    }

    @Override
    public void saveTool(Tool tool) {
       toolRepo.save(tool);
    }

    @Override
    public void deleteTool(Long id) {
        toolRepo.deleteById(id);
    }

    @Override
    public boolean editTool(Long id, Tool tool) {
        
        if (!toolRepo.existsById(id)) {
      
            return false;
        }
            tool.setId(id);
            toolRepo.save(tool);
            return true;
    }
    
    
    
}
