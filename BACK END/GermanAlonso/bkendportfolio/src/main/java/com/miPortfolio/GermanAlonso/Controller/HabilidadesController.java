package com.miPortfolio.GermanAlonso.Controller;

import com.miPortfolio.GermanAlonso.Dto.dtoHabilidades;
import com.miPortfolio.GermanAlonso.Entity.Habilidades;
import com.miPortfolio.GermanAlonso.Security.Controller.Mensaje;
import com.miPortfolio.GermanAlonso.Service.HabilidadesService;
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
@RequestMapping("/habilidades")
@CrossOrigin(origins = "https://portfolio-web-32b2b.web.app")

public class HabilidadesController {
    @Autowired
    HabilidadesService habService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> list = habService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        if(!habService.existById(id))
            return new ResponseEntity(new Mensaje("No existe la habilidad"), HttpStatus.NOT_FOUND);
        Habilidades habilidades = habService.getOne(id).get();
            return new ResponseEntity(habilidades, HttpStatus.OK);
        }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtoHab) {
        if(StringUtils.isBlank(dtoHab.getNombreHab()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        if(habService.existsByNombreHab(dtoHab.getNombreHab()))
            return new ResponseEntity(new Mensaje("Habilidad existente"), HttpStatus.BAD_REQUEST);
        
        Habilidades habilidades = new Habilidades(dtoHab.getNombreHab(), dtoHab.getPorcentaje());
        habService.save(habilidades);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoHabilidades dtoHab){
        //Validacion para ver si existe el id
        if(!habService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Comparacion de nombres de experiencia
        if(habService.existsByNombreHab(dtoHab.getNombreHab()) && habService.getByNombreHab(dtoHab.getNombreHab()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        //nombre en blanco
        if(StringUtils.isBlank(dtoHab.getNombreHab()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Habilidades habilidades = habService.getOne(id).get();
        habilidades.setNombreHab(dtoHab.getNombreHab());
        habilidades.setPorcentaje(dtoHab.getPorcentaje());
        
        habService.save(habilidades);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}") 
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validacion si existe el id
        if(!habService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        habService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);
    }
}


