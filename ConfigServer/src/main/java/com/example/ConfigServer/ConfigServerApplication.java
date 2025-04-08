package com.example.ConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    // This is the main method that starts the Spring Boot application

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
