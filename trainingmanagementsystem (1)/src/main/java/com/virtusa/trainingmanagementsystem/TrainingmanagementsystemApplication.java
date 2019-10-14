package com.virtusa.trainingmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.virtusa.trainingmanagementsystem.*"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages= {"com.virtusa.trainingmanagementsystem.*"})
@EntityScan(basePackages= {"com.virtusa.trainingmanagementsystem.*"})

//@SpringBootApplication
public class TrainingmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingmanagementsystemApplication.class, args);
		
	}

}
