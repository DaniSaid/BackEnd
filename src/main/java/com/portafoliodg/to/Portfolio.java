package com.portafoliodg.to;

import com.portafoliodg.Entity.About;
import com.portafoliodg.Entity.Experience;
import com.portafoliodg.Entity.Skill;
import com.portafoliodg.Entity.Tool;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Portfolio {

    //declaro mi modelo about (atributo del tipo objeto)
    private About about;
    private Tool tool;
    private Skill skill;
    private Experience experience;
    
}
