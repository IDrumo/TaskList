package com.tascks.TaskList.Task.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table
@JsonDeserialize(builder = Task.Builder.class)
public class Task {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private String title;
    private String description;
    private Boolean status;

    public static Builder builder(){
        return new Builder();
    }

    public Task(){}
    public Task(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.status = builder.status;
    }

    public Task(Long id,
                String title,
                String description,
                Boolean status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Task(String title,
                String description,
                Boolean status) {
        this.title = title;
        this.description = description;
        this.status = status;
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


    @JsonPOJOBuilder(withPrefix = "set")
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

        public Task build(){
            return new Task(this);
        }
    }
}
