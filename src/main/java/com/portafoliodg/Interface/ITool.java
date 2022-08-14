package com.portafoliodg.Interface;

import com.portafoliodg.Entity.Tool;
import java.util.List;

public interface ITool {
    
    public List<Tool> getTool();
    
    public void saveTool(Tool tool);
    
    public void deleteTool(Long id);
    
    public boolean editTool(Long id, Tool tool);
    
}
