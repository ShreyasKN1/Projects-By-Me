package com.tatkal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/check")
    public ResponseEntity<String> getSomething()
    {
        return  ResponseEntity.ok("works fine");
    }
    
}
