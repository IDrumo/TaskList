package com.tascks.TaskList.TaskList.web.dto;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {
    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @PostMapping("/tasks")
    public void createTask(@Valid @RequestBody CreateTaskDTO createTaskDTO){
        log.info("Создана новая задача: {}", createTaskDTO);
    }

    @GetMapping("/tasks")
    public void getTask(@RequestBody CreateTaskDTO createTaskDTO){

    }

    @DeleteMapping ("/tasks")
    public void delTask(@RequestBody CreateTaskDTO createTaskDTO){

    }

    @PutMapping ("/tasks")
    public void updateTask(@RequestBody CreateTaskDTO createTaskDTO){

    }
}
