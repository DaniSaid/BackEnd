package com.portafoliodg.Interface;

import com.portafoliodg.Entity.Tool;
import java.util.List;
import java.util.Optional;

public interface ITool {
    
    public List<Tool> getToolList();
    
    public Optional<Tool> getToolById(Long id);
    
    public void saveTool(Tool tool);
    
    public void deleteTool(Long id);
    
    public boolean toolExistsById(Long id);

}
