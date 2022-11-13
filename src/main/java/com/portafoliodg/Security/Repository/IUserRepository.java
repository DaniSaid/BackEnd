package com.portafoliodg.Security.Repository;

import com.portafoliodg.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
    
    Optional<User> findByUserName(String userName);
    
    boolean existsByUserName(String userName);
}
