package com.tascks.TaskList.Task.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Service;

public record ContentDTO (Long id,
                         String title,
                         String description) {


//    public void addValue(Long taskId, String title, String desc) {
//        this.id = taskId;
//        this.title = title;
//        this.description = desc;
//    }
//
//    public void setText(String title, String desc){
//        this.title = title;
//        this.description = desc;
//    }

}
