package com.portafoliodg.Repository;

import com.portafoliodg.Model.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAboutRepository extends JpaRepository <About, Long>{
    
}
