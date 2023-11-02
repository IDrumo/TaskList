package com.tascks.TaskList.Task.Service;

import com.tascks.TaskList.Task.DTO.FullDTO;
import com.tascks.TaskList.Task.Model.Task;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TaskDTOMapper implements Function<Task, FullDTO> {
    @Override
    public FullDTO apply(Task task){
        return new FullDTO(task.getId(),
                           task.getTitle(),
                           task.getDescription(),
                           task.getStatus());
    }
}
