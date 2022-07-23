//Data Tranfer object
package com.miPortfolio.GermanAlonso.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descripExp;
    
    //Constructor

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExp, String descripExp) {
        this.nombreExp = nombreExp;
        this.descripExp = descripExp;
    }
    
    //Getter y Setter

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripExp() {
        return descripExp;
    }

    public void setDescripExp(String descripExp) {
        this.descripExp = descripExp;
    }
    
    
    
}
