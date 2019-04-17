package com.spring.dental.proj.DentalProj.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.spring.dental.proj.DentalProj.utils.ProjectConstants;

@org.springframework.context.annotation.Configuration
public class FileUploadConfig implements WebMvcConfigurer{

	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	       registry
	               .addResourceHandler("/dentist/images/**")
	               .addResourceLocations("file:" + ProjectConstants.DENTIST_IMAGES_PATH)
	               .setCachePeriod(3600)
	               .resourceChain(true)
	               .addResolver(new PathResourceResolver());
	      registry
	      .addResourceHandler("/patient/images/**")
	      .addResourceLocations("file:" + ProjectConstants.PATIENT_IMAGES_PATH)
	      .setCachePeriod(3600)
          .resourceChain(true)
          .addResolver(new PathResourceResolver());
	    }
}
