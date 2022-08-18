
package com.miPortfolio.GermanAlonso.Controller;

import com.miPortfolio.GermanAlonso.Dto.dtoExperiencia;
import com.miPortfolio.GermanAlonso.Entity.Experiencia;
import com.miPortfolio.GermanAlonso.Security.Controller.Mensaje;
import com.miPortfolio.GermanAlonso.Service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explaboral")
@CrossOrigin(origins = "https://portfolio-web-32b2b.web.app")

public class ExperienciaController {
    @Autowired
    ExperienciaService expService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = expService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!expService.existById(id))
            return new ResponseEntity(new Mensaje("No existe la experiencia"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expService.getOne(id).get();
            return new ResponseEntity(experiencia, HttpStatus.OK);
        }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp) {
        if(StringUtils.isBlank(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        if(expService.existByNombreExp(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoExp.getNombreExp(), dtoExp.getDescripExp());
        expService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoExperiencia dtoExp){
        //Validacion para ver si existe el id
        if(!expService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Comparacion de nombres de experiencia
        if(expService.existByNombreExp(dtoExp.getNombreExp()) && expService.getByNombreExp(dtoExp.getNombreExp()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //nombre en blanco
        if(StringUtils.isBlank(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = expService.getOne(id).get();
        experiencia.setNombreExp(dtoExp.getNombreExp());
        experiencia.setDescripExp(dtoExp.getDescripExp());
        
        expService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}") 
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validacion si existe el id
        if(!expService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        expService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }
}
