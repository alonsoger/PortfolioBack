package com.miPortfolio.GermanAlonso.Service;

import com.miPortfolio.GermanAlonso.Entity.Habilidades;
import com.miPortfolio.GermanAlonso.Repository.IHabilidadesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadesService {
    @Autowired
    IHabilidadesRepository habilidadesRep;
    
       public List<Habilidades> list() {
        return habilidadesRep.findAll();
    }
    
    public Optional<Habilidades> getOne(int id){
        return habilidadesRep.findById(id);
    }
    
    public Optional<Habilidades> getByNombreHab(String nombreHab){
        return habilidadesRep.findByNombreHab(nombreHab);
    }
    
    public void save(Habilidades hab) {
        habilidadesRep.save(hab);
    }
    
    public void delete(int id){
        habilidadesRep.deleteById(id);
    }
    
    public boolean existById(int id){
        return habilidadesRep.existsById(id);
    }
    
       public boolean existsByNombreHab(String nombreHab){
        return habilidadesRep.existsByNombreHab(nombreHab);
    }
    
}
