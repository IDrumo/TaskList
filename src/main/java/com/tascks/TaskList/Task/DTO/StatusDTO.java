package com.tascks.TaskList.Task.DTO;

import org.springframework.stereotype.Service;

@Service
public class StatusDTO {
    private Long id;
    private Boolean status;

    public void addValue(Long taskId, Boolean status) {
        this.id = taskId;
        this.status = status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Boolean getStatus() {
        return status;
    }
}
