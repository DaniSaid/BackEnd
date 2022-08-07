package com.portafoliodg.Interface;

import com.portafoliodg.Model.About;
import java.util.List;

public interface IAboutService {
    //traer abouts
    public List<About> getAbouts();
    
    //guardar objeto de tipo persona
    public void saveAbout (About about);
    
    //buscar objeto About por id
    public About findAbout(Long id);
    
    //eliminar objeto identificandolo por el id
    public void deleteAbout(Long id);
   
}
