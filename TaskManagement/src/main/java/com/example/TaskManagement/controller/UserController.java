package com.example.TaskManagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.TaskManagement.entities.User;
import com.example.TaskManagement.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return userService.createUser(name, email, password);
    }
}
