package com.portafoliodg.Interface;

import com.portafoliodg.Model.User;
import java.util.List;

public interface IUserService {
    public List<User> getUsers();
    
    public void saveUser(User user);
    
    public User findUser(Long id);
    
    public void deleteUser(Long id);
}
