// package com.example;

  

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// public class CorsConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         // Allow CORS requests from React frontend
//         registry.addMapping("/**")                      // Enable CORS for all endpoints
//                 .allowedOrigins("http://localhost:3000") // Allow React frontend's origin
//                 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these HTTP methods
//                 .allowedHeaders("*")                  // Allow all headers
//                 .allowCredentials(true);              // Allow credentials (cookies, etc.)
//     }
// }
