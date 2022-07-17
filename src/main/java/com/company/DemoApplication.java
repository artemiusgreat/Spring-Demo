package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.company.config.AppConfig;
import com.company.exception.ExceptionProcessor;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

	public static void main(String[] args) {
        ExceptionProcessor globalExceptionHandler = new ExceptionProcessor();
        Thread.setDefaultUncaughtExceptionHandler(globalExceptionHandler);
        SpringApplication.run(AppConfig.class, args);
	}
}
