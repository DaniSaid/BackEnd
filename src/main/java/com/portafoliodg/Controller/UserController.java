package com.portafoliodg.Controller;

import com.portafoliodg.Interface.IUserService;
import com.portafoliodg.Model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PutMapping("usuario/editar/{id}")
    public User editUser(@PathVariable Long id, @RequestParam("nombre") String name, @RequestParam("contraseña") String password){
        
        User user = iuserService.findUser(id);
        user.setUser(name);
        user.setPassword(password);
        iuserService.saveUser(user);
        return user; 
    }
    
    @DeleteMapping("usuario/borrar/{id}")
    public String deleteUser(@PathVariable Long id){
        iuserService.deleteUser(id);
        return "usuario borrado";
    }
}
