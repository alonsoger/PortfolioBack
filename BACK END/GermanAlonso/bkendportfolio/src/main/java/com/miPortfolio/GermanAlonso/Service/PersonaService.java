package com.miPortfolio.GermanAlonso.Service;

import com.miPortfolio.GermanAlonso.Entity.Persona;
import com.miPortfolio.GermanAlonso.Interface.IPersonaService;
import com.miPortfolio.GermanAlonso.Repository.IPersonaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class PersonaService implements IPersonaService {
    @Autowired
    IPersonaRepository personaRep;
    
    /*
    public Optional<Persona> getOne(int id){
        return personaRep.findById(id);
    }
    
    public Optional<Persona> getByNombrePer(String nombre){
        return personaRep.findByNombrePer(nombre);
    }
    
    public void save(Persona per) {
        personaRep.save(per);
    }
    
    public void delete(int id){
        personaRep.deleteById(id);
    }
    
    public boolean existById(int id) {
        return personaRep.existsById(id);
    }
    
    public boolean existByNombrePer(String nombre) {
        return personaRep.existsByNombrePer(nombre);
    }
    */
    
    @Override
    public List <Persona> getPersona() {
        List<Persona> persona = personaRep.findAllById(id);
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRep.save(persona);
    }

    @Override
    public void deletePersona(int id) {
        personaRep.deleteById(id);
    }

    @Override
    public Persona findPersona(int id) {
        Persona persona = personaRep.findById(id).orElse(null);
        return persona;
    }
    
    public boolean existsById(int id) {
       return personaRep.existsById(id);
    }
    
}
