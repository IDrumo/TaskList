package com.tascks.TaskList.Task.DTO;

import lombok.Getter;
import org.springframework.stereotype.Service;

public record StatusDTO (Long id,
                       Boolean status) {

//    public void addValue(Long taskId, Boolean status) {
//        this.id = taskId;
//        this.status = status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }

}
