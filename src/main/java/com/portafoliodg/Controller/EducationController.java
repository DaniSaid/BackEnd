package com.portafoliodg.Controller;

import com.portafoliodg.Interface.IEducationService;
import com.portafoliodg.Model.Education;
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
public class EducationController {
    @Autowired IEducationService ieducationService;
    
    @GetMapping("educación/traer")
    public List<Education> getEducation(){
        return ieducationService.getEducation();
    }
    
    @PostMapping("educación/crear")
    public String createEducation(@RequestBody Education edu){
        ieducationService.saveEducation(edu);
        return "nuevo item educación creado";
    }
    
    @PutMapping("educación/editar/{id}")
    public Education editEducation(@PathVariable Long id, @RequestParam ("nombre") String nuevoNombre,
                                                            @RequestParam ("nombre_sec") String nuevoNombreSec,
                                                            @RequestParam ("título") String nuevoTitulo,
                                                            @RequestParam ("nivel") String nuevoNivel,
                                                            @RequestParam ("fecha_inicio") int nuevaFechaIni,
                                                            @RequestParam ("fecha_final")int nuevaFechaFinal,
                                                            @RequestParam ("imagen") String nuevaImagen){
        
        Education edu = ieducationService.findEducation(id);
        
        edu.setNombre(nuevoNombre);
        edu.setNombreSec(nuevoNombreSec);
        edu.setTitulo(nuevoTitulo);
        edu.setNivel(nuevoNivel);
        edu.setFechaIni(nuevaFechaIni);
        edu.setFechaFin(nuevaFechaFinal);
        edu.setImg(nuevaImagen);
        
        ieducationService.saveEducation(edu);
        
        return edu;
    }
    
    @DeleteMapping("educación/borrar/{id}")
    public String deleteEducation(@PathVariable Long id){
        ieducationService.deleteEducation(id);
        return "item de educación fue borrado correctamente";
    }
}
