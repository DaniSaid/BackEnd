package com.portafoliodg.Security.Controller;

import com.portafoliodg.Security.DTO.JWTDTO;
import com.portafoliodg.Security.DTO.NewUser;
import com.portafoliodg.Security.DTO.UserLogin;
import com.portafoliodg.Security.Entity.Rol;
import com.portafoliodg.Security.Entity.User;
import com.portafoliodg.Security.Enums.RolNombre;
import com.portafoliodg.Security.JWT.ProviderJWT;
import com.portafoliodg.Security.Service.RolService;
import com.portafoliodg.Security.Service.UserService;
import com.portafoliodg.to.State;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://hosting-angular-e585e.web.app")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    UserService userService;
    @Autowired
    RolService rolService;
    @Autowired
    ProviderJWT providerJWT;
    
    //método para crear usuario nuevo
    @PostMapping("/new/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new State(false,"datos ingresados invalidos"), HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByUserName(newUser.getUserName())) {
            return new ResponseEntity(new State(false, "El nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        User user = new User(newUser.getUserName(), passwordEncoder.encode(newUser.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if (newUser.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        user.setRoles(roles);
        userService.saveUser(user);
        
        return new ResponseEntity(new State(true, "Usuario creado"), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JWTDTO> login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity(new State(false,"datos invalidos"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = providerJWT.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JWTDTO jwtDTO = new JWTDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }
}
