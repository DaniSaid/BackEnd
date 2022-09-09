
package com.portafoliodg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Tool {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;

    public Tool() {
    }

    public Tool(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }
    
    
    
}
