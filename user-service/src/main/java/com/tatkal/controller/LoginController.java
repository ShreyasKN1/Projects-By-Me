package com.tatkal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tatkal.entity.User;
import com.tatkal.service.UserService;

@RestController
@RequestMapping("/api/users")
public class LoginController {

    @Autowired private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }

    @GetMapping("/me")
    public User getUserDetails(@RequestParam String username) {
        return userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }
}

