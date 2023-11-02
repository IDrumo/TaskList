package com.tascks.TaskList.Task.Service;

import com.tascks.TaskList.Task.DTO.ContentDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskContentToDTO {

    public ContentDTO contentDTO(Long id, String title, String description){
        return new ContentDTO(id, title, description);
    }
}
