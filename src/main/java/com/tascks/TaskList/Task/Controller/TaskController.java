package com.tascks.TaskList.Task.Controller;

import com.tascks.TaskList.Task.DTO.*;
import com.tascks.TaskList.Task.Model.Task;
import com.tascks.TaskList.Task.Service.TaskContentToDTO;
import com.tascks.TaskList.Task.Service.TaskIdToDTO;
import com.tascks.TaskList.Task.Service.TaskService;
import com.tascks.TaskList.Task.Service.TaskToDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<FullDTO> getTasks() {
        return taskService.getTasks().stream().map(task -> modelMapper.map(task, FullDTO.class)).collect(Collectors.toList());
    }

//    @GetMapping(path = "{taskId}")
//    public Task getTasks(@PathVariable("taskId") Long taskId) {
//        var task = taskService.getTasks(taskId);
//        var taskDTO = modelMapper.map(task, FullDTO.class);
//        return taskDTO;
//    }

    @PostMapping
    public FullDTO addNewTask(@RequestBody Task task){
        return taskService.addTask(modelMapper.map(task, FullDTO.class));
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(modelMapper.map(taskId, IdDTO.class));
//        taskService.deleteTask(taskIdToDTO.taskIdToDTO(taskId));
    }

    @PutMapping(path = "{taskId}")
    public FullDTO putUpdateTask(@RequestBody RenewDTO newDTO, @PathVariable("taskId") Long taskId) {
        return taskService.putUpdateTask(taskId, newDTO);
    }

}
