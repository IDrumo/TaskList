package com.tascks.TaskList.Task.Service;

import com.tascks.TaskList.Task.DAO.TaskDAO;
import com.tascks.TaskList.Task.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskDAO taskDAO;
    private final TaskDTOMapper taskDTOMapper;

    @Autowired
    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
        taskDTOMapper = new TaskDTOMapper();
    }

    public List<FullDTO> getTasks(){
        return taskDAO.getAllTasks().map(taskDTOMapper)
                .collect(Collectors.toList());
    }
//    public FullDTO getTaskById(Long taskId){
//        return taskDAO.getAllTasks().map(taskDTOMapper);
//    }
    public FullDTO addTask(FullDTO fullDTO){
        return taskDAO.addNewTask(fullDTO);
    }

    public void deleteTask(IdDTO idDTO){
        taskDAO.deleteTaskById(idDTO.id());
    }
    public FullDTO updateFullTask(FullDTO fullDTO){
        return taskDAO.updateTask(fullDTO);
    }
    public FullDTO updateTaskContent(ContentDTO contentDto){
        return taskDAO.updateTask(contentDto);
    }
    public FullDTO updateTaskStatus(StatusDTO statusDTO){
        return taskDAO.updateTask(statusDTO);
    }
    public FullDTO putUpdateTask (Long taskId, RenewDTO renewDTO){
        return taskDAO.putUpdateTask(taskId, renewDTO);
    }
}
