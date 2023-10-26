package com.tascks.TaskList.Task;

import com.tascks.TaskList.Task.DTO.StatusDTO;
import com.tascks.TaskList.Task.DTO.ContentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DATA {
    private static final List<Task> bank = new ArrayList<>();

    public DATA() {

    }

    public void addTask(Task task) {
        bank.add(task);
    }

    public void deleteTask(Long taskId) {
        for (Task task : bank) {
            if (task.getId().equals(taskId)) {
                bank.remove(task);
                return;
            }
        }
        throw new IllegalStateException("задачи с id = " + taskId + " не существует");
    }

    public List<Task> getTasks() {
        return bank;
    }

    public void updateFullTask(Task newTask) {
        for (Task task : bank) {
            if (task.getId().equals(newTask.getId())) {
                task.setTitle(newTask.getTitle());
                task.setDescription(newTask.getDescription());
                task.setStatus(newTask.getStatus());
                return;
            }
        }
        throw new IllegalStateException("Неверно введена задача");
    }

    public void updateTaskText(ContentDTO text) {
        for (Task task : bank) {
            if (task.getId().equals(text.getId())) {
                task.setTitle(text.getTitle());
                task.setDescription(text.getDescription());
                return;
            }
        }
        throw new IllegalStateException("Задачи с id = " + text.getId() + " не существует");
    }

    public void updateTaskStatus(StatusDTO dtoStatus) {
        for (Task task : bank) {
            if (task.getId().equals(dtoStatus.getId())) {
                task.setStatus(dtoStatus.getStatus());
                return;
            }
        }
        throw new IllegalStateException("task with id = " + dtoStatus.getId() + " does not exists");
    }
}
