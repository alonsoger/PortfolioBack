
package com.miPortfolio.GermanAlonso.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHabilidades {
    
    @NotBlank
    private String nombreHab;
    @NotBlank
    private Number porcentaje;
    
    //Constructor

    public dtoHabilidades() {
    }

    public dtoHabilidades(String nombreHab, Number porcentaje) {
        this.nombreHab = nombreHab;
        this.porcentaje = porcentaje;
    }
    
    //Getter y Setter

    public String getNombreHab() {
        return nombreHab;
    }

    public void setNombreHab(String nombreHab) {
        this.nombreHab = nombreHab;
    }

    public Number getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Number porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
