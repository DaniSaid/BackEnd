package com.portafoliodg.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private String puesto;
    private String tipo;
    private int horas;
    private String descripcion;
    private int fechaIni;
    private int fechaFin;
    private String img;

    public Experience() {
    }

    public Experience(Long id, String nombre, String posicion, String tipo, int horas, String descripcion, int fechaIni, int fechaFin, String img) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = posicion;
        this.tipo = tipo;
        this.horas = horas;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.img = img;
    }
    
    
}
