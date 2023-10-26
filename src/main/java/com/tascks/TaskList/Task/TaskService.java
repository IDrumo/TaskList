package com.tascks.TaskList.Task;

import com.tascks.TaskList.Task.DTO.FullDTO;
import com.tascks.TaskList.Task.DTO.StatusDTO;
import com.tascks.TaskList.Task.DTO.ContentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final DATA data;

    public TaskService(DATA data) {
        this.data = data;
        data.addTask(new Task(
                1L,
                "home work",
                "do backend",
                true
        ));
    }

    public List<Task> getTasks(){
        return data.getTasks();
    }
    public void addTask(FullDTO fullDTO){
        data.addTask(fullDTO.toTask());
    }

    public void deleteTask(Long taskId){
        data.deleteTask(taskId);
    }
    public void updateFullTask(FullDTO fullDTO){
        data.updateFullTask(fullDTO.toTask());
    }
    public void updateTaskContent(ContentDTO contentDto){
        data.updateTaskText(contentDto);
    }
    public void updateTaskStatus(StatusDTO statusDTO){
        data.updateTaskStatus(statusDTO);
    }
}
