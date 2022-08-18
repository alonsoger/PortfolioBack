
package com.miPortfolio.GermanAlonso.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu;
    private String fechaEdu;
    private String descripEdu;
    
    
    //Constructor
    public Educacion() {
    }

    public Educacion(String nombreEdu, String fechaEdu, String descripEdu) {
        this.nombreEdu = nombreEdu;
        this.fechaEdu = fechaEdu;
        this.descripEdu = descripEdu;
    }
    //Getter y Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
