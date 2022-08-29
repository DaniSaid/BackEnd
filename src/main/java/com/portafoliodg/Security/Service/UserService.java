package com.portafoliodg.Security.Service;

import com.portafoliodg.Security.Entity.User;
import com.portafoliodg.Security.Repository.IUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    IUserRepository userRepo;
    
    public Optional<User> getByUserName(String user){
        return userRepo.findByUserName(user);
    }
    
    public boolean existsByUserName(String user){
        return userRepo.existsByUserName(user);
    }
    
    public void saveUser(User user){
        userRepo.save(user);
    }
}
