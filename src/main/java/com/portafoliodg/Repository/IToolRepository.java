package com.portafoliodg.Repository;

import com.portafoliodg.Model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToolRepository extends JpaRepository<Tool, Long>{
    
}
