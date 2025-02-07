package com.example.TaskManagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

