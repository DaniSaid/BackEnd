package com.portafoliodg;

import com.portafoliodg.Entity.About;
import com.portafoliodg.Entity.Tool;
import com.portafoliodg.Service.PortfolioServices;
import com.portafoliodg.to.Portfolio;
import com.portafoliodg.to.State;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    
    @Autowired
    private PortfolioServices portfolioS;
    
    @GetMapping("/portfolio/{id}")
    Portfolio getPortfolio(@PathVariable int id){
        return portfolioS.getPortfolio(id);
    }
    //About 
    @GetMapping("/about-lista")
    @ResponseBody
    List<About> getAboutList(){
        return portfolioS.getAboutList();
    }
    
    @GetMapping("/about")
    About getAbout(){
        long id = 2;
        return portfolioS.findAbout(id);
    }
    
    @PostMapping("/portfolio/about/create")
    State createAbout(@RequestBody About about){
        portfolioS.saveAbout(about);
        
        return new State(true, "about creado");
    }
    
    @PostMapping("/portfolio/about/edit")
    State editAboutData(@RequestBody About about){
        return portfolioS.editAbout(about);
    }
    
    @DeleteMapping("/portfolio/about/delete/2")
    State deleteAbout(){
        long id = 2;
        portfolioS.deleteAbout(id);
        
        return new State(true, "about borrado");
    }
    
    //--------------------Tool ----------------------
    
    @GetMapping("/tools")
    @ResponseBody
    public List<Tool> getTool(){
        return portfolioS.getTool();
    }
    
    @PostMapping("/portfolio/tool/create")
    public State createTool(@RequestBody Tool tool){
        portfolioS.saveTool(tool);
        
        return new State(true, "se creó correctamente");
    }
    
    @DeleteMapping("/portfolio/tool/delete/{id}")
    public State deleteTool(@PathVariable Long id){
        
        portfolioS.deleteTool(id);
        
        return new State(true, "borrado correctamente");
    }
    
    @PutMapping("/portfolio/tool/edit/{id}")
    public State editTool(@PathVariable Long id, @RequestBody Tool tool){
        if (!portfolioS.editTool(id, tool)) {
            return new State(false, "el id no existe");
        }
        portfolioS.saveTool(tool);
        return new State(true, "se editó correctamente");
    }
    
    //--------------------    ---------------------
}
