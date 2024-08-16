package com.jo4ovms.taskmanager.repository;

import com.jo4ovms.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}