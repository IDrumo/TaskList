package com.tascks.TaskList.Task.Service;

import com.tascks.TaskList.Task.DTO.FullDTO;
import com.tascks.TaskList.Task.Model.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskToDTO {
    public static FullDTO taskToDTO(Task task){
        return new FullDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );
    }
}
