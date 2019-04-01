package com.spring.dental.proj.DentalProj.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

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
}
