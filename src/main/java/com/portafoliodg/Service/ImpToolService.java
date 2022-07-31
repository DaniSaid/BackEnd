package com.portafoliodg.Service;

import com.portafoliodg.Interface.IToolService;
import com.portafoliodg.Model.Tool;
import com.portafoliodg.Repository.IToolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpToolService implements IToolService{

    @Autowired IToolRepository itoolRepository;
    
    @Override
    public List<Tool> getTools() {
        List<Tool> tool = itoolRepository.findAll();
        return tool;
    }

    @Override
    public void saveTool(Tool tool) {
        itoolRepository.save(tool);
    }

    @Override
    public Tool findTool(Long id) {
        Tool tool = itoolRepository.findById(id).orElse(null);
        return tool;
    }

    @Override
    public void deleteTool(Long id) {
        itoolRepository.deleteById(id);
    }
    
}
