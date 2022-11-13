package com.portafoliodg.Interface;

import com.portafoliodg.Entity.Project;
import java.util.List;
import java.util.Optional;

public interface IProject {
    
    public List<Project> getProjectList();
    
    public Optional<Project> getProjectById(Long id);
    
    public void saveProject(Project project);
    
    public void deleteProject(Long id);
    
    public boolean projectExistsById(Long id);

}
