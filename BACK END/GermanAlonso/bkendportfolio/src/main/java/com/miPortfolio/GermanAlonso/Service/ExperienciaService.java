
package com.miPortfolio.GermanAlonso.Service;

import com.miPortfolio.GermanAlonso.Entity.Experiencia;
import com.miPortfolio.GermanAlonso.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //Mantiene la persistencia
public class ExperienciaService {
    @Autowired
    IExperienciaRepository experienciaRep;
    
    public List<Experiencia> list() {
        return experienciaRep.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return experienciaRep.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return experienciaRep.findByNombreExp(nombreExp);
    }
    
    public void save(Experiencia exp) {
        experienciaRep.save(exp);
    }
    
    public void delete(int id){
        experienciaRep.deleteById(id);
    }
    
    public boolean existById(int id){
        return experienciaRep.existsById(id);
    }
    
    public boolean existByNombreExp(String nombreExp){
        return experienciaRep.existsByNombreExp(nombreExp);
    }
    
}
