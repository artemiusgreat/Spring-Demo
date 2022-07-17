package com.company.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.company" })
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
    	ModelMapper map = new ModelMapper();    	
        map.getConfiguration().setPreferNestedProperties(false);
    	return map;
    }
}
