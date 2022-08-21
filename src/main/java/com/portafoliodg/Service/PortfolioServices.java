package com.portafoliodg.Service;

import com.portafoliodg.Entity.About;
import com.portafoliodg.Entity.Experience;
import com.portafoliodg.Entity.Skill;
import com.portafoliodg.Entity.Tool;
import com.portafoliodg.Interface.IExperience;
import com.portafoliodg.Interface.ISkill;
import com.portafoliodg.Interface.ITool;
import com.portafoliodg.Repository.AboutRepository;
import com.portafoliodg.Repository.ExperienceRepository;
import com.portafoliodg.Repository.SkillRepository;
import com.portafoliodg.Repository.ToolRepository;
import com.portafoliodg.to.Portfolio;
import com.portafoliodg.to.State;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PortfolioServices implements ITool, ISkill, IExperience{
    
    @Autowired AboutRepository aboutRepo;
    @Autowired ToolRepository toolRepo;
    @Autowired SkillRepository skillRepo;
    @Autowired ExperienceRepository expRepo;
    
    //-----------Portafolio-----------------
    public Portfolio getPortfolio(long aboutId){
        //recupera los datos de about desde el repositorio(la persistencia)
        About about = aboutRepo.findById(aboutId).orElse(null);
        
        
        //manda la info al portfolio
        Portfolio portfolio = new Portfolio();
        portfolio.setAbout(about);
        //queda agregar los demas componentes
        
        return portfolio;
        
    }
    
    //------------Acerca de ------------------
    
    public List<About> getAboutList(){
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
    
    public State editAbout(About about){
        if (about!=null && aboutRepo.existsById(about.getId())) {
            aboutRepo.save(about);
            
            return new State(true, "Acerca de, actualizado");
        }
        
        return new State(false, "Acerca de, no se ha actualizado");
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
    
    //-------------implementacion de metodos Skill--------------------
    @Override
    public List<Skill> getSkills() {
        return skillRepo.findAll();
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public boolean editSkill(Long id, Skill skill) {
        if (!skillRepo.existsById(id)) {
            return false;
        }
            skill.setId(id);
            skillRepo.save(skill);
            
            return true;
    }

    @Override
    public Skill getSkillById(Long id) {
        
        Skill skill = skillRepo.findById(id).orElse(null);
        return skill;
    }

    //-------------implementacion de metodos Experiencia--------------------
    @Override
    public List<Experience> getExperiences() {
        return expRepo.findAll();
    }

    @Override
    public Optional<Experience> getExpById(Long id) {
         return expRepo.findById(id);
    }

    @Override
    public void saveExp(Experience exp) {
        expRepo.save(exp);
    }

    @Override
    public void deleteExp(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public boolean expExistsById(Long id) {
        return expRepo.existsById(id);
    }

}
