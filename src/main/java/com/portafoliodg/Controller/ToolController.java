package com.portafoliodg.Controller;

import com.portafoliodg.Interface.IToolService;
import com.portafoliodg.Model.Tool;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToolController {
    @Autowired IToolService itoolService;
    
    @GetMapping("tool/traer")
    public List<Tool> getTools(){
        return itoolService.getTools();
    }
    
    @PostMapping("tool/crear")
    public String saveTool(@RequestBody Tool tool){
        itoolService.saveTool(tool);
        return "herramienta creada";
    }
    
    @PutMapping("tool/editar/{id}")
    public Tool editTool(@PathVariable Long id, @RequestParam String toolName, @RequestParam String img){
        
        Tool tool = itoolService.findTool(id);
        
        tool.setTool(toolName);
        tool.setImg(img);
        
        itoolService.saveTool(tool);
        
        return tool;
    }
    
    @DeleteMapping("tool/borrar/{id}")
    public String deleteTool(@PathVariable Long id){
        itoolService.deleteTool(id);
        return "herramienta borrada correctamente";
    }
}
