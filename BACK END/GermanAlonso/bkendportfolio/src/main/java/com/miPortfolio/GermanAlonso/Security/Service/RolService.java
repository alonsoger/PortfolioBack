package com.miPortfolio.GermanAlonso.Security.Service;

import com.miPortfolio.GermanAlonso.Security.Entity.Rol;
import com.miPortfolio.GermanAlonso.Security.Enums.RolNombre;
import com.miPortfolio.GermanAlonso.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //Persistencia con la base de datos. RolBack 
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre (RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save (Rol rol) {
        irolRepository.save(rol);
    }
}
