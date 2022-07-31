package com.portafoliodg.Service;

import com.portafoliodg.Interface.IProjectService;
import com.portafoliodg.Model.Project;
import com.portafoliodg.Repository.IProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpProjectService implements IProjectService{

    @Autowired IProjectRepository iprojectRepository;
    
    @Override
    public List<Project> getProjects() {
        
        List<Project> project = iprojectRepository.findAll();
        return project;
        
    }

    @Override
    public void saveProject(Project project) {
        
        iprojectRepository.save(project);
                
    }

    @Override
    public Project findProject(Long id) {
        Project project = iprojectRepository.findById(id).orElse(null);
        return project;
    }

    @Override
    public void deleteProject(Long id) {
        iprojectRepository.deleteById(id);
    }
    
}
