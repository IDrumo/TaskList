package com.tascks.TaskList.Task.repositories;

import com.tascks.TaskList.Task.Model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Optional<Task> findTaskById(Long id);
}
