package com.portafoliodg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Project {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String detalle;
    private String repo;
    private String web;
    private String imagen;

    public Project() {
    }

    public Project(String nombre, String detalle,String repo, String web, String imagen) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.repo = repo;
        this.web = web;
        this.imagen = imagen;
    }
    
}
