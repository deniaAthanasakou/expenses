package com.project.expenses;

import com.project.expenses.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.util.logging.Logger;

@Configuration
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = { "com.project.expenses" }, excludeFilters = { @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = { SecurityConfig.class }) })
public class ExpensesApplication {

	private final static Logger LOGGER = Logger.getLogger(ExpensesApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
		LOGGER.info("App has been deployed successfully");
	}

}
