package com.tascks.TaskList.Task;

public class Task {

    private Long id;
    private String title;
    private String desc;
    private Boolean status; // 0 - to do, 1 - in process, 2 - done, 3 - abandoned

    public Task() {

    }

    public Task(Long id,
                String title,
                String desc,
                Boolean status) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc(){return desc;}

    public void setDesc(String desc){this.desc = desc;}

    public Boolean getStatus(){return status;}

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Task{" +
                "id=" + id +
                ", title='" + title + "'" +
                ", desc='" + desc + "'" +
                ", status=" + status +
                "}";

    }
}
