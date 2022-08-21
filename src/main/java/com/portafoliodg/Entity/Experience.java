package com.portafoliodg.Entity;

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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String puesto;
    private String detalle;
    private String tipo;
    private String nombreEmpresa;
    private int fechaIni;
    private int fechaFin;

    public Experience() {
    }

    public Experience( String puesto, String detalle, String tipo, String nombreEmpresa, int fechaIni, int fechaFin) {
     
        this.puesto = puesto;
        this.detalle = detalle;
        this.tipo = tipo;
        this.nombreEmpresa = nombreEmpresa;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }
    
    
}
