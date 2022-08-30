package com.portafoliodg.Service;

import com.portafoliodg.Entity.About;
import com.portafoliodg.Entity.Education;
import com.portafoliodg.Entity.Experience;
import com.portafoliodg.Entity.Skill;
import com.portafoliodg.Entity.Tool;
import com.portafoliodg.Interface.IEducation;
import com.portafoliodg.Interface.IExperience;
import com.portafoliodg.Interface.ISkill;
import com.portafoliodg.Interface.ITool;
import com.portafoliodg.Repository.AboutRepository;
import com.portafoliodg.Repository.EducationRepository;
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
public class PortfolioServices implements ITool, ISkill, IExperience, IEducation{
    
    @Autowired AboutRepository aboutRepo;
    @Autowired ToolRepository toolRepo;
    @Autowired SkillRepository skillRepo;
    @Autowired ExperienceRepository expRepo;
    @Autowired EducationRepository eduRepo;
    
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
    
    //-------------Herramientas--------------------

    @Override
    public List<Tool> getToolList() {
        return toolRepo.findAll();
    }
    
    @Override
    public Optional<Tool> getToolById(Long id) {
        return toolRepo.findById(id);
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
    public boolean toolExistsById(Long id) {
        return toolRepo.existsById(id);
    }
    
    //-------------implementacion de metodos Skill--------------------
    @Override
    public List<Skill> getSkillList() {
        return skillRepo.findAll();
    }
    
    @Override
    public Optional<Skill> getSkillById(Long id) {
        
        return skillRepo.findById(id);
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
    public boolean skillExistsById(Long id) {
        return skillRepo.existsById(id);
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
    
    //-------------implementacion de metodos Educación--------------------

    @Override
    public List<Education> getEducationList() {
        return eduRepo.findAll();
    }
    
    @Override
    public Optional<Education> getEducationById(Long id) {
        return eduRepo.findById(id);
    }

    @Override
    public void saveEducation(Education edu) {
        eduRepo.save(edu);
    }
    
    @Override
    public void deleteEducation(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public boolean eduExistsById(Long id) {
        return eduRepo.existsById(id);
    }


}
