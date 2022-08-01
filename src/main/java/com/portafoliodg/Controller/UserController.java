package com.portafoliodg.Controller;

import com.portafoliodg.Interface.IUserService;
import com.portafoliodg.Model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired IUserService iuserService;
    
    @GetMapping("usuario/traer")
    public List<User> getUsers(){
        return iuserService.getUsers();
    }
    
    @PostMapping("usuario/crear")
    public String createUser(User user){
        iuserService.saveUser(user);
        return "nuevo usuario creado";
    }
    
    @DeleteMapping("usuario/borrar")
    public String deleteUser(Long id){
        iuserService.deleteUser(id);
        return "usuario borrado";
    }
}
