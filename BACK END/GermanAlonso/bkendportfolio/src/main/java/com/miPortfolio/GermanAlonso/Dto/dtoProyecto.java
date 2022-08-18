package com.miPortfolio.GermanAlonso.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private String proyUrl;
    @NotBlank
    private String proyTitulo;
    @NotBlank
    private String proyFoto;

    
    // Constructor
    public dtoProyecto() {
    }

    public dtoProyecto(String proyUrl, String proyTitulo, String proyFoto) {
        this.proyUrl = proyUrl;
        this.proyTitulo = proyTitulo;
        this.proyFoto = proyFoto;
    }
    
    //Getter y Setter

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

