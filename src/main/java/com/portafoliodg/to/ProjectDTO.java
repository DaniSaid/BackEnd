package com.portafoliodg.to;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProjectDTO {
    @NotBlank
    private String nombre;
    private String detalle;
    private String repo;
    private String web;
    private String imagen;

    public ProjectDTO() {
    }

    public ProjectDTO(String nombre, String detalle, String repo, String web, String imagen) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.repo = repo;
        this.web = web;
        this.imagen = imagen;
    }
    
}
