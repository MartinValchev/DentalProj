package com.spring.dental.proj.DentalProj.config;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.spring.dental.proj.DentalProj.utils.DateTimeConverter;
import com.spring.dental.proj.DentalProj.utils.ProjectConstants;

@org.springframework.context.annotation.Configuration
public class FileUploadConfig implements WebMvcConfigurer{

	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	       registry
	               .addResourceHandler(ProjectConstants.DENTIST_IMAGES_MAPPED_PATH +"/**")
	               .addResourceLocations("file:" + ProjectConstants.DENTIST_IMAGES_PATH)
	               .setCachePeriod(3600)
	               .resourceChain(true)
	               .addResolver(new PathResourceResolver());
	      registry
			      .addResourceHandler(ProjectConstants.PATIENT_IMAGES_MAPPED_PATH + "/**")
			      .addResourceLocations("file:" + ProjectConstants.PATIENT_IMAGES_PATH)
			      .setCachePeriod(3600)
		          .resourceChain(true)
		          .addResolver(new PathResourceResolver());
	      
	      registry
			      .addResourceHandler(ProjectConstants.MEDICAL_EXAMINATION_IMAGES_PATH +"/**")
			      .addResourceLocations("file:"  + ProjectConstants.MEDICAL_EXAMINATION_IMAGES_PATH )
			      .setCachePeriod(3600)
		          .resourceChain(true)
		          .addResolver(new PathResourceResolver());
	      
		         
	    }
/*	 @Override
	 public void addFormatters(FormatterRegistry registry) {
	     registry.addConverter(new DateTimeConverter());

	 }*/
}
