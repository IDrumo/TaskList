package com.tascks.TaskList.Task.Controller;

import com.tascks.TaskList.Task.DTO.FullDTO;
import com.tascks.TaskList.Task.DTO.RenewDTO;
import com.tascks.TaskList.Task.DTO.StatusDTO;
import com.tascks.TaskList.Task.DTO.ContentDTO;
import com.tascks.TaskList.Task.Model.Task;
import com.tascks.TaskList.Task.Service.TaskContentToDTO;
import com.tascks.TaskList.Task.Service.TaskIdToDTO;
import com.tascks.TaskList.Task.Service.TaskService;
import com.tascks.TaskList.Task.Service.TaskToDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskToDTO taskToDTO;
    private final TaskIdToDTO taskIdToDTO;
    private final TaskContentToDTO taskContentToDTO;

    public TaskController(TaskService taskService, TaskToDTO taskToDTO, TaskIdToDTO taskIdToDTO, TaskContentToDTO taskContentToDTO) {
        this.taskService = taskService;
        this.taskToDTO = taskToDTO;
        this.taskIdToDTO = taskIdToDTO;
        this.taskContentToDTO = taskContentToDTO;
    }

    @GetMapping
    public List<FullDTO> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public FullDTO addNewTask(@RequestBody Task task){
        return taskService.addTask(taskToDTO.taskToDTO(task));
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskIdToDTO.taskIdToDTO(taskId));
    }

    @PutMapping(path = "{taskId}")
    public FullDTO putUpdateTask(@RequestBody RenewDTO newDTO, @PathVariable("taskId") Long taskId) {
        return taskService.putUpdateTask(taskId, newDTO);
    }

}
