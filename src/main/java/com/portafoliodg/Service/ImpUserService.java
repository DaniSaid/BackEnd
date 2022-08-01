package com.portafoliodg.Service;

import com.portafoliodg.Interface.IUserService;
import com.portafoliodg.Model.User;
import com.portafoliodg.Repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpUserService implements IUserService{
    
    @Autowired IUserRepository iuserRepository;
    
    @Override
    public List<User> getUsers() {
        List<User> users = iuserRepository.findAll();
        return users;
    }

    @Override
    public void saveUser(User user) {
        iuserRepository.save(user);
    }

    @Override
    public User findUser(Long id) {
        User user = iuserRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        iuserRepository.deleteById(id);
    }
    
}
