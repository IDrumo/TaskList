package com.tascks.TaskList.Task.DAO;

import com.tascks.TaskList.Task.DTO.ContentDTO;
import com.tascks.TaskList.Task.DTO.FullDTO;
import com.tascks.TaskList.Task.DTO.RenewDTO;
import com.tascks.TaskList.Task.DTO.StatusDTO;
import com.tascks.TaskList.Task.Model.Task;
import com.tascks.TaskList.Task.Service.TaskContentToDTO;
import com.tascks.TaskList.Task.Service.TaskToDTO;
import com.tascks.TaskList.Task.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TaskDAO {
    private final TaskToDTO taskToDTO;
    private final TaskRepository taskRepository;

    public TaskDAO (TaskToDTO taskToDTO, TaskRepository taskRepository){
        this.taskToDTO = taskToDTO;
        this.taskRepository = taskRepository;
    }

    public Stream<Task> getAllTasks() {
        return Streamable.of(taskRepository.findAll()).stream();
    }

    public FullDTO addNewTask(FullDTO fullDTO) {
        Optional<Task> taskOptional = taskRepository.findTaskById(fullDTO.id());
        if (taskOptional.isPresent()) {
            throw new IllegalStateException("id taken");
        }
        taskRepository.save(new Task(
                fullDTO.id(),
                fullDTO.title(),
                fullDTO.description(),
                fullDTO.status()
        ));
        return fullDTO;
    }

    @Transactional
    public FullDTO updateTask(ContentDTO contentDTO) {

        Task task = taskRepository.findById(contentDTO.id()).orElseThrow(() ->
                new IllegalStateException("task with id " + contentDTO.id() + "does not exists"));

        if (contentDTO.title() != null && !contentDTO.title().isEmpty() && !Objects.equals(task.getTitle(), contentDTO.title())) {
            System.out.println("got it!");
            task.setTitle(contentDTO.title());
        }

        if (contentDTO.description() != null && !contentDTO.description().isEmpty() && !Objects.equals(task.getDescription(), contentDTO.description())) {
            Optional<Task> taskOptional = taskRepository.findTaskById(contentDTO.id());
            if (taskOptional.isPresent()) {
                throw new IllegalStateException("id taken");
            }
            task.setDescription(contentDTO.description());
        }

        return TaskToDTO.taskToDTO(task);
    }

    @Transactional
    public FullDTO updateTask(FullDTO fullDTO) {

        Task task = taskRepository.findById(fullDTO.id()).orElseThrow(() ->
                new IllegalStateException("task with id " + fullDTO.id() + "does not exists"));

        if (fullDTO.title() != null && !fullDTO.title().isEmpty() && !Objects.equals(task.getTitle(), fullDTO.title())) {
            System.out.println("got it!");
            task.setTitle(fullDTO.title());
        }

        if (fullDTO.description() != null && !fullDTO.description().isEmpty() && !Objects.equals(task.getDescription(), fullDTO.description())) {
            Optional<Task> taskOptional = taskRepository.findTaskById(fullDTO.id());
            if (taskOptional.isPresent()) {
                throw new IllegalStateException("id taken");
            }
            task.setDescription(fullDTO.description());
        }

        return TaskToDTO.taskToDTO(task);
    }

    @Transactional
    public FullDTO updateTask(StatusDTO statusDTO) {

        Task task = taskRepository.findById(statusDTO.id()).orElseThrow(() ->
                new IllegalStateException("task with id " + statusDTO.id() + "does not exists"));

        if (!Objects.equals(task.getStatus(), statusDTO.status())) {
            System.out.println("got it!");
            task.setStatus(statusDTO.status());
        }

        return TaskToDTO.taskToDTO(task);
    }

    public void deleteTaskById(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if (!exists) {
            throw new IllegalStateException("task with id " + taskId + " does not exists");
        }
        taskRepository.deleteById(taskId);
    }

    @Transactional
    public FullDTO putUpdateTask(Long taskId, RenewDTO renewDTO){
        Task task = taskRepository.findById(taskId).orElseThrow(() ->
                new IllegalStateException("task with id " + taskId + "does not exists"));
        if (renewDTO.title() == null){
            throw new IllegalStateException("title must be not null value");
        }
        if (renewDTO.description() == null){
            throw new IllegalStateException("email must be not null value");
        }
        if (renewDTO.status() == null){
            throw new IllegalStateException("status must be not null value");
        }
        task.setTitle(renewDTO.title());
        task.setDescription(renewDTO.description());
        task.setStatus(renewDTO.status());
        return TaskToDTO.taskToDTO(new Task(taskId, renewDTO.title(), renewDTO.description(), renewDTO.status()));
    }
}