package com.portafoliodg.to;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ToolDTO {
    @NotBlank
    private String nombre;
    private String imagen;

    public ToolDTO() {
    }

    public ToolDTO(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }
    
}
