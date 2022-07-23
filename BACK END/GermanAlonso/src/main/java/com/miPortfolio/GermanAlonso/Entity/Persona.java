package com.miPortfolio.GermanAlonso.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 30, message = "No cumple con los parametros")
    private String nombre;
 
    @NotNull
    @Size(min = 1, max = 30, message = "No cumple con los parametros")
    private String apellido;
   
    @Size(min = 1, max = 30, message = "Insertar imagen")
    private String img;
    
    @NotNull
    private String titulo;
    
    @NotNull
    private String descripPer;
    
    //Contructores

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String titulo, String descripPer) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
        this.descripPer = descripPer;
    }
    
    //Getter y Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripPer() {
        return descripPer;
    }

    public void setDescripPer(String descripPer) {
        this.descripPer = descripPer;
    }
    
    
}
