package com.miPortfolio.GermanAlonso.Service;

import com.miPortfolio.GermanAlonso.Entity.Educacion;
import com.miPortfolio.GermanAlonso.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired
    IEducacionRepository educacionRep;
    
    public List<Educacion> list(){
        return educacionRep.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return educacionRep.findById(id);
    }
    
    public Optional<Educacion> getByNombreEdu(String nombreEdu){
        return educacionRep.findByNombreEdu(nombreEdu);
    }
    
    public void save(Educacion edu){
        educacionRep.save(edu);
    }
    
    public void delete(int id){
        educacionRep.deleteById(id);
    }
    
    public boolean existById(int id){
        return educacionRep.existsById(id);
    }
    
    public boolean existByNombreEdu (String nombreEdu){
        return educacionRep.existsByNombreEdu(nombreEdu);
    }
}
