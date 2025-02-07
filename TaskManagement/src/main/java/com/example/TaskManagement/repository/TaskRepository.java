package com.example.TaskManagement.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManagement.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
