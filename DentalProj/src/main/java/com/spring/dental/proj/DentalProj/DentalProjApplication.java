package com.spring.dental.proj.DentalProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.spring.dental.proj.DentalProj.domain.entities"}) 
public class DentalProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalProjApplication.class, args);
	}
	

	
}
