package com.portafoliodg;

import com.portafoliodg.Entity.About;
import com.portafoliodg.Entity.Experience;
import com.portafoliodg.Entity.Skill;
import com.portafoliodg.Entity.Tool;
import com.portafoliodg.Service.PortfolioServices;
import com.portafoliodg.to.ExperienceDTO;
import com.portafoliodg.to.Portfolio;
import com.portafoliodg.to.State;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    
    @Autowired
    private PortfolioServices portfolioS;
    
    @GetMapping("/portfolio/{id}")
    Portfolio getPortfolio(@PathVariable int id){
        return portfolioS.getPortfolio(id);
    }
    //About
    //en uso
    @GetMapping("/about-list")
    @ResponseBody
    List<About> getAboutList(){
        return portfolioS.getAboutList();
    }
    
    @GetMapping("/about")
    About getAbout(){
        long id = 2;
        return portfolioS.findAbout(id);
    }
    
    @PostMapping("/portfolio/about/create")
    State createAbout(@RequestBody About about){
        portfolioS.saveAbout(about);
        
        return new State(true, "about creado");
    }
    
    //en uso
    @PostMapping("/portfolio/about/edit")
    State editAboutData(@RequestBody About about){
        return portfolioS.editAbout(about);
    }
    
    @DeleteMapping("/portfolio/about/delete/2")
    State deleteAbout(){
        long id = 2;
        portfolioS.deleteAbout(id);
        
        return new State(true, "about borrado");
    }
    
    //--------------------Tool ----------------------
    
    @GetMapping("/tools-list")
    @ResponseBody
    public List<Tool> getTool(){
        return portfolioS.getTool();
    }
    
    @PutMapping("/portfolio/tool/edit/{id}")
    public State editTool(@PathVariable Long id, @RequestBody Tool tool){
        if (!portfolioS.editTool(id, tool)) {
            return new State(false, "el id no existe");
        }
        portfolioS.saveTool(tool);
        return new State(true, "se editó correctamente");
    }
    
    @PostMapping("/portfolio/tool/create")
    public State createTool(@RequestBody Tool tool){
        portfolioS.saveTool(tool);
        
        return new State(true, "se creó correctamente");
    }
    
    @DeleteMapping("/portfolio/tool/delete/{id}")
    public State deleteTool(@PathVariable Long id){
        
        portfolioS.deleteTool(id);
        
        return new State(true, "borrado correctamente");
    }
    
    
    
    //--------------------Skill---------------------
    @GetMapping("/skills-list")
    @ResponseBody
    public List<Skill> getSkills(){
        return portfolioS.getSkills();
    }
    
    @GetMapping("/portfolio/skill/{id}")
    public Skill getSkillById(@PathVariable Long id){
        return portfolioS.getSkillById(id);
    }
    
    @PutMapping("/portfolio/skill/edit/{id}")
    public State editSkill(@PathVariable Long id, @RequestBody Skill skill){
        if (!portfolioS.editSkill(id, skill)) {
            return new State(false, "el id no existe");
        }
        portfolioS.saveSkill(skill);
        
        return new State(true, "se editó correctamente");
    }
    
    @PostMapping("/portfolio/skill/create")
    public State createSkill(@RequestBody Skill skill){
        portfolioS.saveSkill(skill);
        return new State(true, "nueva skill creada");
    }
    
    //------------------Experience---------------------
    
    @GetMapping("/experience-list")
    public List<Experience> getExperiences(){
        return portfolioS.getExperiences();
    }
    
     @GetMapping("/experience/detail/{id}")
     public ResponseEntity<Experience> getExpById(@PathVariable("id") Long id){
         if (!portfolioS.expExistsById(id)) {
             return new ResponseEntity(new State(false,"id no existe"), HttpStatus.NOT_FOUND);
         }
         Experience exp = portfolioS.getExpById(id).get();
         
         return new ResponseEntity(exp, HttpStatus.OK);
     }
     
     @DeleteMapping("/experience/delete/{id}")
     public ResponseEntity<?> deleteExp(@PathVariable("id") Long id){
         if (!portfolioS.expExistsById(id)) {
             return new ResponseEntity(new State(false, "id no existe"), HttpStatus.NOT_FOUND);
         }
         portfolioS.deleteExp(id);
         return new ResponseEntity(new State(true, "exp borrada"), HttpStatus.OK);
     }
     
     @PostMapping("/experience/create")
     public ResponseEntity<?> createExp(@RequestBody ExperienceDTO expDTO){
         if (StringUtils.isBlank(expDTO.getPuesto())) {
             return new ResponseEntity(new State(false, "el puesto es obligatorio"), HttpStatus.BAD_REQUEST);
         }
         
         Experience experience = new Experience(expDTO.getPuesto(),expDTO.getDetalle(),expDTO.getTipo(),expDTO.getNombreEmpresa(),expDTO.getFechaIni(),expDTO.getFechaFin());
         portfolioS.saveExp(experience);
         
         return new ResponseEntity(new State(true, "exp agregada"), HttpStatus.OK);
     }
     
     @PutMapping("/experience/update/{id}")
     public ResponseEntity<?> updateExperience(@PathVariable("id") Long id, @RequestBody ExperienceDTO expDTO){
         if (!portfolioS.expExistsById(id)) {
             return new ResponseEntity(new State(false," id no existe"), HttpStatus.BAD_REQUEST);
         }
         if (StringUtils.isBlank(expDTO.getPuesto())) {
             return new ResponseEntity(new State(false, "el puesto es obligatorio"), HttpStatus.BAD_REQUEST);
         }
         
         Experience exp = portfolioS.getExpById(id).get();
         exp.setPuesto(expDTO.getPuesto());
         exp.setDetalle(expDTO.getDetalle());
         exp.setTipo(expDTO.getTipo());
         exp.setNombreEmpresa(expDTO.getNombreEmpresa());
         exp.setFechaIni(expDTO.getFechaIni());
         exp.setFechaFin(expDTO.getFechaFin());
         
         portfolioS.saveExp(exp);
         
         return new ResponseEntity(new State(true, "experiencia actualizada"),HttpStatus.OK);
     }
}
