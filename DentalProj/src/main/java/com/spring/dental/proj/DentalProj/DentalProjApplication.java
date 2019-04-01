package com.spring.dental.proj.DentalProj;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.spring.dental.proj.DentalProj.utils.CommonService;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.spring.dental.proj.DentalProj.domain.entities"}) 
public class DentalProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalProjApplication.class, args);
	}
	

	
}
