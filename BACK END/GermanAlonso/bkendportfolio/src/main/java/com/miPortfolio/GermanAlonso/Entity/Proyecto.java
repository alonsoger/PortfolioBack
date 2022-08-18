package com.miPortfolio.GermanAlonso.Entity;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String proyUrl;
    private String proyTitulo;
    private String proyFoto;

    //Constructores 

    public Proyecto() {
    }

    public Proyecto(String proyUrl, String proyTitulo, String proyFoto) {
        this.proyUrl = proyUrl;
        this.proyTitulo = proyTitulo;
        this.proyFoto = proyFoto;
    }
    
    //Getter y Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProyUrl() {
        return proyUrl;
    }

    public void setProyUrl(String proyUrl) {
        this.proyUrl = proyUrl;
    }

    public String getProyTitulo() {
        return proyTitulo;
    }

    public void setProyTitulo(String proyTitulo) {
        this.proyTitulo = proyTitulo;
    }

    public String getProyFoto() {
        return proyFoto;
    }

    public void setProyFoto(String proyFoto) {
        this.proyFoto = proyFoto;
    }
    
    
}
