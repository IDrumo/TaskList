package com.tascks.TaskList.TaskList.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @PostMapping("/tasks")
    public void createTask(@RequestBody CreateTaskDTO createTaskDTO){
        log.info("Создана новая задача: {}", createTaskDTO);
    }
}
