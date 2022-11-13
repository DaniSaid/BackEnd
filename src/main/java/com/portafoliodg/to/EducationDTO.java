package com.portafoliodg.to;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducationDTO {
    
    @NotBlank
    private String titulo;
    private String detalle;
    private int fechaIni;
    private int fechaFin;
    private String imagen;

    public EducationDTO() {
    }

    public EducationDTO(String titulo, String detalle, int fechaIni, int fechaFin, String imagen) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.imagen = imagen;
    }
    
    
}
