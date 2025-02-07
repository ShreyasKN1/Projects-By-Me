package com.example.TaskManagement.controller;

import com.example.TaskManagement.entities.Task;
import com.example.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestParam String title, @RequestParam String description, @RequestParam Long creatorId) {
        return taskService.createTask(title, description, creatorId);
    }

    @PostMapping("/{taskId}/approve")
    public void approveTask(@PathVariable Long taskId, @RequestParam Long approverId, @RequestParam String comment) {
        taskService.approveTask(taskId, approverId, comment);
    }
}

