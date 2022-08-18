package com.miPortfolio.GermanAlonso.Service;

import com.miPortfolio.GermanAlonso.Entity.Proyecto;
import com.miPortfolio.GermanAlonso.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    IProyectoRepository proyectoRep;
    
    public List<Proyecto> list() {
        return proyectoRep.findAll();
    }
    
    public void save(Proyecto proy){
        proyectoRep.save(proy);
    }
    
    public void delete(int id){
        proyectoRep.deleteById(id);
    }
    
    public boolean existById(int id){
        return proyectoRep.existsById(id);
    }
   
    
    public Optional<Proyecto> getOne(int id){
        return proyectoRep.findById(id);
    }

    
}
