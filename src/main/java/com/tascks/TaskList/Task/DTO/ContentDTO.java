package com.tascks.TaskList.Task.DTO;

import org.springframework.stereotype.Service;

@Service
public class ContentDTO {
    private Long id;
    private String title;
    private String description;

    public void addValue(Long taskId, String title, String desc) {
        this.id = taskId;
        this.title = title;
        this.description = desc;
    }

    public void setText(String title, String desc){
        this.title = title;
        this.description = desc;
    }

    public Long getId(){return id;}
    public String getTitle(){return title;}
    public String getDescription(){return description;}
}
