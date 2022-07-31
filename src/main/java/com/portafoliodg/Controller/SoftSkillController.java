package com.portafoliodg.Controller;

import com.portafoliodg.Interface.ISoftSkillService;
import com.portafoliodg.Model.SoftSkill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoftSkillController {
    
    @Autowired ISoftSkillService iskillService;
    
    @GetMapping("skill/traer")
    public List<SoftSkill> getSoftSkills(){
        return iskillService.getSoftSkills();
    }
    
    @PostMapping("skill/crear")
    public String saveSoftSkill(@RequestBody SoftSkill skill){
        iskillService.saveSoftSkill(skill);
        return "item habilidad creado correctamente";
    }
    
    @PutMapping("skill/editar/{id}")
    public SoftSkill editSoftSkill(@PathVariable Long id, @RequestParam ("skill") String skill){
        
        SoftSkill softSkill = iskillService.findSoftSkill(id);
        
        softSkill.setSkill(skill);
        
        iskillService.saveSoftSkill(softSkill);
        
        return softSkill;
    }
    
    @DeleteMapping("skill/borrar/{id}")
    public String deleteSoftSkill(@PathVariable Long id){
        iskillService.deleteSoftSkill(id);
        return "item habilidad borrado correctamente";
    }

}
