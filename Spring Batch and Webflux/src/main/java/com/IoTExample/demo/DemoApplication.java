package com.IoTExample.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages={
	"com.IoTExample.repository",
	"com.IoTExample.batchConfig",
	"com.IoTExample.controller",
	"com.IoTExample.Scheduling",
	"com.IoTExample.service"
})
@EnableJpaRepositories(basePackages={"com.IoTExample.repository"})
@EntityScan(basePackages = {"com.IoTExample.entity"})
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
