package com.miPortfolio.GermanAlonso.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String fechaEdu;
    @NotBlank
    private String descripEdu;
    
    //Contructor

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEdu, String fechaEdu, String descripEdu) {
        this.nombreEdu = nombreEdu;
        this.fechaEdu = fechaEdu;
        this.descripEdu = descripEdu;
    }
    
    //Getter y Setter

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }

    public String getDescripEdu() {
        return descripEdu;
    }

    public void setDescripEdu(String descripEdu) {
        this.descripEdu = descripEdu;
    }
    
}
