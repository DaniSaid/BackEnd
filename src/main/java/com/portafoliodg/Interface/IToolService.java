package com.portafoliodg.Interface;

import com.portafoliodg.Model.Tool;
import java.util.List;

public interface IToolService {
    public List<Tool> getTools();
    
    public void saveTool(Tool tool);
    
    public Tool findTool(Long id);
    
    public void deleteTool(Long id);
}
