package com.tascks.TaskList.Task.DTO;

import com.tascks.TaskList.Task.Model.Task;
import lombok.Getter;
import org.springframework.stereotype.Service;

public record FullDTO (Long id,
                          String title,
                          String description,
                          Boolean status) {


//    public void addValue(Long taskId, String title, String desc, Boolean status) {
//        this.id = taskId;
//        this.title = title;
//        this.description = desc;
//        this.status = status;
//    }
//
//    public void setId(Long id){
//        this.id = id;
//    }
//    public void setText(String title, String desc){
//        this.title = title;
//        this.description = desc;
//    }
//
//    public void setStatus(Boolean status){
//        this.status = status;
//    }
//
//    public Task toTask(){
//        return new Task(id, title, description, status);
//    }
}
