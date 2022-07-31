package com.portafoliodg.Interface;

import com.portafoliodg.Model.Project;
import java.util.List;

public interface IProjectService {
    
    public List<Project> getProjects();
    
    public void saveProject(Project project);
    
    public Project findProject(Long id);
    
    public void deleteProject(Long id);
    
}
