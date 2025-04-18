package com.tatkal.user_service;

import com.tatkal.entity.User;
import com.tatkal.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

     private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username) 
                     .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

                     logger.debug("Username: " + username);
                     logger.debug("Encoded password: " + user.getPassword()); 

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList() // or use user.getRoles() if roles are implemented
        );
    }
}

