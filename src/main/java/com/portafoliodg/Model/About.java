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
public class About implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String titulo;
    private String pais;
    private String provincia;  
    private String descripcion;  
    private String img;

    public About() {
    }

    public About(Long id, String nombre, String apellido, String titulo, String pais, String provincia, String descripcion, String img) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.pais = pais;
        this.provincia = provincia;
        this.descripcion = descripcion;
        this.img = img;
    }
    

}
