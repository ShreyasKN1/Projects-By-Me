package com.example.TaskManagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.TaskManagement.entities.User;
import com.example.TaskManagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create and Save a User
    public User createUser(String name, String email, String password) {
        if (userRepository.findByEmail(email)!=null) {
            throw new RuntimeException("User with email already exists.");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // Encrypt password

        return userRepository.save(user);
    }
}
