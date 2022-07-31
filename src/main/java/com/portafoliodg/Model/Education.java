package com.portafoliodg.Model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Education implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String nombreSec;
    private String titulo;
    private String nivel;
    private int fechaIni;
    private int fechaFin;
    private String img;

    public Education() {
    }

    public Education(Long id, String nombre, String nombreSec, String titulo, String nivel, int fechaIni, int fechaFin, String img) {
        this.id = id;
        this.nombre = nombre;
        this.nombreSec = nombreSec;
        this.titulo = titulo;
        this.nivel = nivel;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.img = img;
    }
    
    
}
