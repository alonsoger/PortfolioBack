package com.miPortfolio.GermanAlonso.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habilidades implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHab;
    private Number porcentaje;
    
    //Contructores

    public Habilidades() {
    }

    public Habilidades(String nombreHab, Number porcentaje) {
        this.nombreHab = nombreHab;
        this.porcentaje = porcentaje;
    }
    
    //Getter y Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
