package com.example.TaskManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManagement.entities.Task;
import com.example.TaskManagement.entities.TaskApproval;
import com.example.TaskManagement.entities.User;

import java.util.List;
public interface TaskApprovalRepo extends JpaRepository<TaskApproval, Long> {

        List<TaskApproval> findByTask(Task task);
        boolean existsByTaskAndApprover(Task task, User approver);
    
    
}
