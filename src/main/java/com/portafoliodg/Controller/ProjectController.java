package com.portafoliodg.Controller;

import com.portafoliodg.Interface.IProjectService;
import com.portafoliodg.Model.Project;
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
public class ProjectController {
    
    @Autowired IProjectService iprojectService;
    
    @GetMapping("proyecto/traer")
    public List<Project> getProjects(){
        List<Project> projects = iprojectService.getProjects();
        return projects;
    }
    
    @PostMapping("proyecto/crear")
    public String saveProject(@RequestBody Project project){
        
        iprojectService.saveProject(project);
        return "nuevo proyecto creado correctamente";
        
    }
    
    @PutMapping("proyecto/editar/{id}")
    public Project editProject(@PathVariable Long id, @RequestParam String nombre,@RequestParam String img, @RequestParam String descripcion){
    
        Project project = iprojectService.findProject(id);
        
        project.setNombre(nombre);
        project.setDescripcion(descripcion);
        project.setImg(img);
        
        iprojectService.saveProject(project);
        
        return project;
        
    }
    
    @DeleteMapping("proyecto/borrar/{id}")
    public String deleteProject(@PathVariable Long id){
        iprojectService.deleteProject(id);
        return "el proyecto fue borrado correctamente";
    }
}
