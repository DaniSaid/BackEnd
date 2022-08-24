package com.portafoliodg;

import com.portafoliodg.Entity.About;
import com.portafoliodg.Entity.Education;
import com.portafoliodg.Entity.Experience;
import com.portafoliodg.Entity.Skill;
import com.portafoliodg.Entity.Tool;
import com.portafoliodg.Service.PortfolioServices;
import com.portafoliodg.to.EducationDTO;
import com.portafoliodg.to.ExperienceDTO;
import com.portafoliodg.to.Portfolio;
import com.portafoliodg.to.SkillDTO;
import com.portafoliodg.to.State;
import com.portafoliodg.to.ToolDTO;
import java.util.List;
import java.util.Optional;
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
    // -------------------About-----------------
    @GetMapping("/about/list")
    @ResponseBody
    List<About> getAboutList(){
        return portfolioS.getAboutList();
    }
   
    @PostMapping("/portfolio/about/create")
    State createAbout(@RequestBody About about){
        portfolioS.saveAbout(about);
        
        return new State(true, "about creado");
    }
    
    @PutMapping("/portfolio/about/edit")
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
    
    @GetMapping("/tools/list")
    @ResponseBody
    public List<Tool> getToolList(){
        return portfolioS.getToolList();
    }
    
    @GetMapping("/tool/detail/{id}")
     public ResponseEntity<Tool> getToolById(@PathVariable("id") Long id){
         if (!portfolioS.toolExistsById(id)) {
             return new ResponseEntity(new State(false,"id no existe"), HttpStatus.NOT_FOUND);
         }
         Tool tool = portfolioS.getToolById(id).get();
         
         return new ResponseEntity(tool, HttpStatus.OK);
    }
    
    @PostMapping("/tool/create")
     public ResponseEntity<?> createTool(@RequestBody ToolDTO toolDTO){
          if (StringUtils.isBlank(toolDTO.getNombre())) {
             return new ResponseEntity(new State(false, "el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
         }
         
        Tool tool = new Tool(toolDTO.getNombre(), toolDTO.getImagen());
         portfolioS.saveTool(tool);
         
         return new ResponseEntity(new State(true, "herramienta agregada"), HttpStatus.OK);
     }
    
    @PutMapping("/tool/update/{id}")
    public ResponseEntity<?> updateTool(@PathVariable("id") Long id, @RequestBody ToolDTO toolDTO){
           if (StringUtils.isBlank(toolDTO.getNombre())) {
             return new ResponseEntity(new State(false, "el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
         }
         
         Tool tool = portfolioS.getToolById(id).get();
         tool.setNombre(toolDTO.getNombre());
         tool.setImagen(toolDTO.getImagen());
         
         portfolioS.saveTool(tool);
         
         return new ResponseEntity(new State(true, "herramienta actualizada"),HttpStatus.OK);
     }
    
    @DeleteMapping("/tool/delete/{id}")
    public ResponseEntity<?> deleteTool(@PathVariable("id") Long id){
         if (!portfolioS.toolExistsById(id)) {
             return new ResponseEntity(new State(false, "id no existe"), HttpStatus.NOT_FOUND);
         }
         portfolioS.deleteTool(id);
         return new ResponseEntity(new State(true, "herramienta borrada"), HttpStatus.OK);
     }
    
    
    //--------------------Skill---------------------
    
    @GetMapping("/skill/list")
    public List<Skill> getSkillList(){
        return portfolioS.getSkillList();
    }
    
    @GetMapping("/skill/detail/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable("id") Long id){
        if (!portfolioS.skillExistsById(id)) {
            return new ResponseEntity(new State(false,"el id no existe"),HttpStatus.NOT_FOUND);
        }
        Skill skill = portfolioS.getSkillById(id).get();
        
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    
    @PutMapping("/skill/update/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable("id") Long id, @RequestBody SkillDTO skillDTO){
        if (StringUtils.isBlank(skillDTO.getSkill())) {
            return new ResponseEntity(new State(false,"el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = portfolioS.getSkillById(id).get();
        skill.setSkill(skillDTO.getSkill());
        
        portfolioS.saveSkill(skill);
        
        return new ResponseEntity(new State(true, "habilidad actualizada"), HttpStatus.OK);
    }
    
    //------------------Experience---------------------
    
    @GetMapping("/experience/list")
    public List<Experience> getExperienceList(){
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
     
    @DeleteMapping("/experience/delete/{id}")
     public ResponseEntity<?> deleteExp(@PathVariable("id") Long id){
         if (!portfolioS.expExistsById(id)) {
             return new ResponseEntity(new State(false, "id no existe"), HttpStatus.NOT_FOUND);
         }
         portfolioS.deleteExp(id);
         return new ResponseEntity(new State(true, "exp borrada"), HttpStatus.OK);
     }
     
     //------------------Education---------------------
     @GetMapping("/education/list")
     public List<Education> getEducationList(){
         return portfolioS.getEducationList();
     }
     
     @GetMapping("/education/detail/{id}")
     public ResponseEntity<Education> getEducation(@PathVariable("id") Long id){
         if (!portfolioS.eduExistsById(id)) {
             return new ResponseEntity(new State(false, "id no existe"), HttpStatus.NOT_FOUND);
         }
         Education edu = portfolioS.getEducationById(id).get();
         
         return new ResponseEntity(edu, HttpStatus.OK);
     } 
     
     @PostMapping("/education/create")
     public ResponseEntity<?> createEducation(@RequestBody EducationDTO eduDTO){
          if (StringUtils.isBlank(eduDTO.getTitulo())) {
             return new ResponseEntity(new State(false, "el titulo es obligatorio"), HttpStatus.BAD_REQUEST);
         }
         
         Education edu = new Education(eduDTO.getTitulo(), eduDTO.getDetalle(), eduDTO.getFechaIni(), eduDTO.getFechaFin(), eduDTO.getImagen());
         portfolioS.saveEducation(edu);
         
         return new ResponseEntity(new State(true, "educación agregada"), HttpStatus.OK);
     }
     
     @PutMapping("/education/update/{id}")
     public ResponseEntity<?> updateEducation(@PathVariable("id") Long id, @RequestBody EducationDTO eduDTO){
         if (!portfolioS.eduExistsById(id)) {
             return new ResponseEntity(new State(false," id no existe"), HttpStatus.BAD_REQUEST);
         }
         if (StringUtils.isBlank(eduDTO.getTitulo())) {
             return new ResponseEntity(new State(false, "el titulo es obligatorio"), HttpStatus.BAD_REQUEST);
         }
         
         Education edu = portfolioS.getEducationById(id).get();
         edu.setTitulo(eduDTO.getTitulo());
         edu.setDetalle(eduDTO.getDetalle());
         edu.setFechaIni(eduDTO.getFechaIni());
         edu.setFechaFin(eduDTO.getFechaFin());
         edu.setImagen(eduDTO.getImagen());
         
         portfolioS.saveEducation(edu);
         return new ResponseEntity(new State(true, "educación actualizada"),HttpStatus.OK);
     }
     
     @DeleteMapping("/education/delete/{id}")
     public ResponseEntity<?> deleteEducation(@PathVariable("id") Long id){
         if (!portfolioS.eduExistsById(id)) {
             return new ResponseEntity(new State(false, "id no existe"), HttpStatus.NOT_FOUND);
         }
         portfolioS.deleteEducation(id);
         return new ResponseEntity(new State(true, "exp borrada"), HttpStatus.OK);
     }
}
