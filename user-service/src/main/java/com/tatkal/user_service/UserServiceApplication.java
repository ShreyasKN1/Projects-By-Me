package com.tatkal.user_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.tatkal.user_service",
    "com.tatkal.security", // <-- Add this
    "com.tatkal.config",   // Just in case
    "com.tatkal.repository",
    "com.tatkal.utility"
})
@EnableJpaRepositories(basePackages = "com.tatkal.repository")
@EntityScan(basePackages = "com.tatkal.entity")
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {
            // Get all bean names from the application context
            String[] beanNames = applicationContext.getBeanDefinitionNames();

            System.out.println("Beans registered in the application context:");
            for (String beanName : beanNames) {
				if (beanName.contains("userService")) {  // Filter beans by 'userService' in the name
				System.out.println(beanName);
			}
            }
        };
    }


}
