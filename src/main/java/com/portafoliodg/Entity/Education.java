package com.portafoliodg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Education {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String detalle;
    private int fechaIni;
    private int fechaFin;
    private String imagen;

    public Education() {
    }

    public Education(String titulo, String detalle, int fechaIni, int fechaFin, String imagen) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.imagen = imagen;
    }
    
    
}
