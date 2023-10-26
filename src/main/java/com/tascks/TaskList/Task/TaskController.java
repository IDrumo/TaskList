package com.tascks.TaskList.Task;

import com.tascks.TaskList.Task.DTO.FullDTO;
import com.tascks.TaskList.Task.DTO.StatusDTO;
import com.tascks.TaskList.Task.DTO.ContentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/task")
public class TaskController {
    private final TaskService taskService;
    private final FullDTO fullDTO;
    private final ContentDTO contentDto;
    private final StatusDTO statusDTO;

    public TaskController(TaskService taskService, FullDTO fullDTO, ContentDTO contentDto, StatusDTO statusDTO) {
        this.taskService = taskService;
        this.fullDTO = fullDTO;
        this.contentDto = contentDto;
        this.statusDTO = statusDTO;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public void addNewTask(@RequestBody Task task){
        fullDTO.addValue(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
        taskService.addTask(fullDTO);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
    }

    @PutMapping
    public void updateTask(@RequestBody Task task) {
        if (task.getTitle() != null && task.getDescription() != null && task.getStatus() != null) {
            fullDTO.addValue(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
            taskService.updateFullTask(fullDTO);
        }
        if (task.getTitle() != null && task.getDescription() != null) {
            contentDto.addValue(task.getId(), task.getTitle(), task.getDescription());
            taskService.updateTaskContent(contentDto);
        }
        if (task.getStatus() != null) {
            statusDTO.addValue(task.getId(), task.getStatus());
            taskService.updateTaskStatus(statusDTO);
        }
    }

}
