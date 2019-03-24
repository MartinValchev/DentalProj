package com.spring.dental.proj.DentalProj.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;

public interface DentistService {
	List<DentistServiceModel> getAllDentists();
	DentistServiceModel getDentistById(Long id);
	DentistServiceModel addDentist(DentistServiceModel dentist);
	
	
	
	/*
	 * constructs full image path,
	 * sends image file using full image path
	 * return full image path
	 */
	String processDentistImage(String imageName,MultipartFile file);
}
