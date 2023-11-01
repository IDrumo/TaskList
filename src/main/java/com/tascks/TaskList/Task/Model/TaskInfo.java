package com.tascks.TaskList.Task.Model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.tascks.TaskList.Task.DTO.Task;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskInfo {
    private Long id;
    private String title;
    private String description;
    private Boolean status;

    public static Builder builder(){
        return new Builder();
    }
    public TaskInfo(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.status = builder.status;
    }

    @Override
    public String toString(){
        return "Task{" +
                "id=" + id +
                ", title='" + title + "'" +
                ", desc='" + description + "'" +
                ", status=" + status +
                "}";

    }


    public static class Builder{
        private Long id;
        private String title;
        private String description;
        private Boolean status;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setStatus(Boolean status) {
            this.status = status;
            return this;
        }

        public TaskInfo build(){
            return new TaskInfo(this);
        }
    }
}
