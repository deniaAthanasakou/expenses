package com.project.expenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
@SpringBootApplication
@EnableConfigurationProperties
public class ExpensesApplication {

	private final static Logger LOGGER = Logger.getLogger(ExpensesApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
		LOGGER.info("App has been deployed successfully");
	}

}
