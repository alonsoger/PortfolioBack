package com.miPortfolio.GermanAlonso.Controller;

import com.miPortfolio.GermanAlonso.Dto.dtoEducacion;
import com.miPortfolio.GermanAlonso.Entity.Educacion;
import com.miPortfolio.GermanAlonso.Security.Controller.Mensaje;
import com.miPortfolio.GermanAlonso.Service.EducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")

public class EducacionController {

    @Autowired
    EducacionService eduService;

    @GetMapping("/list")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = eduService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if(!eduService.existById(id))
            return new ResponseEntity(new Mensaje("No existe la educacion"), HttpStatus.NOT_FOUND);
        Educacion educacion = eduService.getOne(id).get();
            return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu) {
        if(StringUtils.isBlank(dtoEdu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        if (eduService.existByNombreEdu(dtoEdu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("Educacion Existente"), HttpStatus.BAD_REQUEST);

        Educacion educacion = new Educacion(dtoEdu.getNombreEdu(), dtoEdu.getFechaEdu(), dtoEdu.getDescripEdu());
        eduService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion guardada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu) {
        //Validamos si existe el id
        if (!eduService.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        //Comparamos nombres de educacion
        if (eduService.existByNombreEdu(dtoEdu.getNombreEdu()) && eduService.getByNombreEdu(dtoEdu.getNombreEdu()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Educacion existente"), HttpStatus.BAD_REQUEST);
        //Nombre en blanco
        if (StringUtils.isBlank(dtoEdu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);

        Educacion educacion = eduService.getOne(id).get();
        educacion.setNombreEdu(dtoEdu.getNombreEdu());
        educacion.setFechaEdu(dtoEdu.getFechaEdu());
        educacion.setDescripEdu(dtoEdu.getDescripEdu());

        eduService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validacion 
        if (!eduService.existById(id))
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        
        eduService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion borrada exitosamente"), HttpStatus.OK);
    }

}
