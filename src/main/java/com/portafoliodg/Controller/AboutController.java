package com.portafoliodg.Controller;

import com.portafoliodg.Interface.IAboutService;
import com.portafoliodg.Model.About;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {
    @Autowired IAboutService iaboutService;
    
    @GetMapping("about/traer")
    public List<About> getAbout(){
        return iaboutService.getAbout();
    }
    
    @PostMapping("about/crear")
    public String createAbout(@RequestBody About about){
        iaboutService.saveAbout(about);
        return "se creo un nuevo about";
    }
    
    
    @PutMapping("/about/editar/{id}")
    public About editAbout(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre,
                                                  @RequestParam("apellido") String nuevoApellido,
                                                  @RequestParam("titulo") String nuevoTitulo,
                                                  @RequestParam("país") String nuevoPais,
                                                  @RequestParam("provincia") String nuevaProvincia,
                                                  @RequestParam("descripción") String nuevaDescripcion,
                                                  @RequestParam("imagen") String nuevaImg){
        
        About about = iaboutService.findAbout(id);
        about.setNombre(nuevoNombre);
        about.setApellido(nuevoApellido);
        about.setTitulo(nuevoTitulo);
        about.setPais(nuevoPais);
        about.setProvincia(nuevaProvincia);
        about.setDescripcion(nuevaDescripcion);
        about.setImg(nuevaImg);
        
        iaboutService.saveAbout(about);
        
        return about;
    }
    
    @DeleteMapping("/about/borrar/{id}")
    public String deleteAbout(@PathVariable Long id){
        iaboutService.deleteAbout(id);
        return "el about fue eliminado correctamente";
    }
    
    @PatchMapping("/about/actualizar/{id}")
    public About actualizarParcialmente(@PathVariable Long id, @RequestParam("titulo") String titulo){
        
       About about = iaboutService.findAbout(id);
       about.setTitulo(titulo);
       iaboutService.saveAbout(about);
       
       return about;
    
    }
}
