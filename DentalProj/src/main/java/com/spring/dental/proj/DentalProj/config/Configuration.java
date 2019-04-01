package com.spring.dental.proj.DentalProj.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.dental.proj.DentalProj.utils.CommonService;

@org.springframework.context.annotation.Configuration
public class Configuration {
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public CommonService getCommonService() {
		return new CommonService();
	}
	
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
