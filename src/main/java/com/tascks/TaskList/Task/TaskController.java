package com.tascks.TaskList.Task;

import com.tascks.TaskList.Task.DTO.FullDTO;
import com.tascks.TaskList.Task.DTO.StatusDTO;
import com.tascks.TaskList.Task.DTO.ContentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/task")
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
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping
    public void addNewTask(@RequestBody Task task){
        fullDTO.addValue(task.getId(), task.getTitle(), task.getDesc(), task.getStatus());
        taskService.addTask(fullDTO);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId){
        taskService.deleteTask(taskId);
    }

    @PutMapping(path = "{taskId}")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String desc,
            @RequestParam(required = false) Boolean status
            ){
        if (title != null && desc != null && status!=null) {
            fullDTO.addValue(taskId, title, desc, status);
            taskService.updateFullTask(fullDTO);
        }
        if (title != null && desc != null){
            contentDto.addValue(taskId, title, desc);
            taskService.updateTaskContent(contentDto);
        }
        if (status != null) {
            statusDTO.addValue(taskId,status);
            taskService.updateTaskStatus(statusDTO);
        }
    }

}
