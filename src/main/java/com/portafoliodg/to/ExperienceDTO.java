/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafoliodg.to;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author kala
 */
public class ExperienceDTO {
    
    @NotBlank
    private String puesto;
    @NotBlank
    private String detalle;
    private String tipo;
    private String nombreEmpresa;
    private int fechaIni;
    private int fechaFin;

    public ExperienceDTO() {
    }

    public ExperienceDTO(String puesto, String detalle, String tipo, String nombreEmpresa, int fechaIni, int fechaFin) {
        this.puesto = puesto;
        this.detalle = detalle;
        this.tipo = tipo;
        this.nombreEmpresa = nombreEmpresa;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(int fechaIni) {
        this.fechaIni = fechaIni;
    }

    public int getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(int fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
