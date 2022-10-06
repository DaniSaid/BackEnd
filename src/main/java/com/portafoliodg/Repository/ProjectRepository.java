package com.portafoliodg.Repository;

import com.portafoliodg.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
