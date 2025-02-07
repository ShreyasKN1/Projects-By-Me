package com.example.TaskManagement.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManagement.entities.Task;
import com.example.TaskManagement.entities.TaskApproval;
import com.example.TaskManagement.entities.User;
import com.example.TaskManagement.enums.TaskStatus;
import com.example.TaskManagement.repository.TaskApprovalRepo;
import com.example.TaskManagement.repository.TaskRepository;
import com.example.TaskManagement.repository.UserRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskApprovalRepo taskApprovalRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    public Task createTask(String title, String description, Long creatorId) {
        User creator = userRepository.findById(creatorId).orElseThrow(() -> new RuntimeException("User not found"));
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setCreator(creator);
        task.setStatus(TaskStatus.PENDING);
        taskRepository.save(task);
        return task;
    }

    public void approveTask(Long taskId, Long approverId, String comment) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        User approver = userRepository.findById(approverId).orElseThrow(() -> new RuntimeException("Approver not found"));

        if (taskApprovalRepository.existsByTaskAndApprover(task, approver)) {
            throw new RuntimeException("Already approved");
        }

        TaskApproval approval = new TaskApproval();
        approval.setTask(task);
        approval.setApprover(approver);
        approval.setComment(comment);
        taskApprovalRepository.save(approval);

        List<TaskApproval> approvals = taskApprovalRepository.findByTask(task);

        //approval by multiple users
        if (approvals.size() >= 3) {
            task.setStatus(TaskStatus.APPROVED);
            taskRepository.save(task);
            emailService.sendApprovalNotification(task.getCreator().getEmail(), task.getTitle());
        }
    }
}

