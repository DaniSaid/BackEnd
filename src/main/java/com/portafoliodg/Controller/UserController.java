package com.portafoliodg.Controller;

import com.portafoliodg.Interface.IUserService;
import com.portafoliodg.Model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired IUserService iuserService;
    
    @GetMapping("usuario/traer")
    public List<User> getUsers(){
        return iuserService.getUsers();
    }
    
    @PostMapping("usuario/crear")
    public String createUser(@RequestBody User user){
        iuserService.saveUser(user);
        return "nuevo usuario creado";
    }
    
    @DeleteMapping("usuario/borrar/{id}")
    public String deleteUser(@PathVariable Long id){
        iuserService.deleteUser(id);
        return "usuario borrado";
    }
}
