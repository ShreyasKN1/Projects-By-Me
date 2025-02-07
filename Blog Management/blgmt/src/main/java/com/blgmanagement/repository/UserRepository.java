package com.blgmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blgmanagement.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
 
    
}
