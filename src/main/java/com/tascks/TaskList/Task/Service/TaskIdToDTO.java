package com.tascks.TaskList.Task.Service;

import com.tascks.TaskList.Task.DTO.IdDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskIdToDTO {
    public IdDTO taskIdToDTO(Long id){
        return new IdDTO(id);
    }
}
