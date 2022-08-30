package com.portafoliodg.Security.Service;

import com.portafoliodg.Security.Entity.Rol;
import com.portafoliodg.Security.Enums.RolNombre;
import com.portafoliodg.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional mantiene sincronizados el service y la bd(persistencia)
@Transactional
public class RolService {
    @Autowired 
    IRolRepository rolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepo.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        rolRepo.save(rol);
    }
    
}
