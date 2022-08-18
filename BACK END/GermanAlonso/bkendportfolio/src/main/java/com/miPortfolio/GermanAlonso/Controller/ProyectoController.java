package com.miPortfolio.GermanAlonso.Controller;

import com.miPortfolio.GermanAlonso.Dto.dtoProyecto;
import com.miPortfolio.GermanAlonso.Entity.Proyecto;
import com.miPortfolio.GermanAlonso.Security.Controller.Mensaje;
import com.miPortfolio.GermanAlonso.Service.ProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://portfolio-web-32b2b.web.app")

public class ProyectoController {
    @Autowired
    ProyectoService proyService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proyService.existById(id))
            return new ResponseEntity(new Mensaje("No existe el proyecto"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyService.getOne(id).get();
            return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoProy) {
        if(StringUtils.isBlank(dtoProy.getProyUrl()))
            return new ResponseEntity(new Mensaje("URL obligatoria"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtoProy.getProyUrl(), dtoProy.getProyTitulo(), dtoProy.getProyFoto());
        proyService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto guardade exitosamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoProyecto dtoProy){
        if(!proyService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoProy.getProyUrl()))
            return new ResponseEntity(new Mensaje("URL obligatoria"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = proyService.getOne(id).get();
        proyecto.setProyUrl(dtoProy.getProyUrl());
        proyecto.setProyTitulo(dtoProy.getProyTitulo());
        proyecto.setProyFoto(dtoProy.getProyFoto());
        
        proyService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!proyService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        proyService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    
    
}
