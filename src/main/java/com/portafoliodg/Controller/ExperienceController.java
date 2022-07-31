package com.portafoliodg.Controller;

import com.portafoliodg.Interface.IExperienceService;
import com.portafoliodg.Model.Experience;
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
public class ExperienceController {
    @Autowired IExperienceService iexpService;
    
    @GetMapping("experiencia/traer")
    public List<Experience> getExperience(){
        return iexpService.getExperience();
    }
    
    @PostMapping("experiencia/crear")
    public String createExperience(@RequestBody Experience exp){
        iexpService.saveExperience(exp);
        return "nuevo item de experiencia creado";
    }
    
    @PutMapping("experiencia/editar/{id}")
    public Experience editExperience(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre,
                                                            @RequestParam("puesto") String nuevoPuesto,
                                                            @RequestParam("tipo") String nuevoTipo,
                                                            @RequestParam("horas") int nuevaHora,
                                                            @RequestParam("descripción") String nuevaDescripcion,
                                                            @RequestParam("fecha_inicio") int nuevaFechaIni,
                                                            @RequestParam("fecha_final") int nuevaFechaFinal,
                                                            @RequestParam("imagen") String nuevaImagen){
        
        Experience exp = iexpService.findExperience(id);
        
        exp.setNombre(nuevoNombre);
        exp.setPuesto(nuevoPuesto);
        exp.setTipo(nuevoTipo);
        exp.setHoras(nuevaHora);
        exp.setDescripcion(nuevaDescripcion);
        exp.setFechaIni(nuevaFechaIni);
        exp.setFechaFin(nuevaFechaFinal);
        exp.setImg(nuevaImagen);
        
        iexpService.saveExperience(exp);
        return exp;
    }
    
    @DeleteMapping("experiencia/borrar/{id}")
    public String deleteExperience(@PathVariable Long id){
        
        iexpService.deleteExperience(id);
        
        return "el item de experiencia se borró correctamente";
    }
}
