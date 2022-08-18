package com.miPortfolio.GermanAlonso.Controller;

import com.miPortfolio.GermanAlonso.Entity.Persona;
import com.miPortfolio.GermanAlonso.Service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-web-32b2b.web.app")

public class PersonaController {

    @Autowired
    PersonaService perService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return perService.getPersona();
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return perService.findPersona((int) 1);
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        perService.savePersona(persona);
        return "Persona creada con existo";
    }
    
    @DeleteMapping("/personas/delete/{id}")
    public String deletePersona(@PathVariable int id){
        perService.deletePersona(id);
        return "Persona borrada correctamente";
    }
    /*
    @PutMapping("/personas/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoPer){
        if(!perService.existsById(id))
            return new ResponseEntity(new Mensaje("Id existente"), HttpStatus.BAD_REQUEST);
        Persona persona = perService.findPersona(id);
        persona.setNombre(dtoPer.getNombre());
        persona.setApellido(dtoPer.getApellido());
        persona.setImg(dtoPer.getImg());
        persona.setTitulo(dtoPer.getTitulo());
        persona.setDescripPer(dtoPer.getDescripPer());
        
        return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
        
    }
    */
  
    
    @PutMapping("/personas/update/{id}")
    public Persona update(@PathVariable int id, 
            @RequestParam( name = "nombre") String nombre,
            @RequestParam( name = "apellido") String apellido,
            @RequestParam( name = "img") String img,
            @RequestParam( name = "titulo") String titulo,
            @RequestParam( name = "descripPer") String descripPer){
        Persona persona = perService.findPersona(id);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setImg(img);
        persona.setTitulo(titulo);
        persona.setDescripPer(descripPer);
        
        perService.savePersona(persona);
        return persona;
    }
    
/*
    @GetMapping("/personas/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!perService.existById(id)) {
            return new ResponseEntity(new Mensaje("No existe la persona"), HttpStatus.NOT_FOUND);
        }
        Persona persona = perService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return (Persona) perService.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public ResponseEntity<?> createPersona(@RequestBody dtoPersona dtoPer) {
        if (StringUtils.isBlank(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (perService.existByNombrePer(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtoPer.getNombre(), dtoPer.getApellido(), dtoPer.getTitulo(), dtoPer.getDescripPer(), dtoPer.getImg());
        perService.save(persona);
        return new ResponseEntity (new Mensaje("Persona creada correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable int id) {
        perService.delete(id);
        return "Persona eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoPersona dtoPer){
        //Validacion para ver si existe el id
        if(!perService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Comparacion de nombres de personas
        if(perService.existByNombrePer(dtoPer.getNombre()) && perService.getByNombrePer(dtoPer.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La Persona ya existe"), HttpStatus.BAD_REQUEST);
        //nombre en blanco
        if(StringUtils.isBlank(dtoPer.getNombre()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = perService.getOne(id).get();
        persona.setNombre(dtoPer.getNombre());
        persona.setApellido(dtoPer.getApellido());
        persona.setTitulo(dtoPer.getTitulo());
        persona.setDescripPer(dtoPer.getDescripPer());
        persona.setImg(dtoPer.getImg());
        
        perService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
*/
}
