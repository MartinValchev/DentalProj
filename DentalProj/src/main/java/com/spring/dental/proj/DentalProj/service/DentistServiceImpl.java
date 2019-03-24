package com.spring.dental.proj.DentalProj.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dental.proj.DentalProj.domain.entities.Dentist;
import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;
import com.spring.dental.proj.DentalProj.domain.repository.DentistRepository;
import com.spring.dental.proj.DentalProj.utils.ProjectConstants;

@Service
public class DentistServiceImpl implements DentistService {

	@Autowired
	DentistRepository dentistRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<DentistServiceModel> getAllDentists() {
		List<Dentist> dentistList = dentistRepository.findAll();
		return (dentistList != null && dentistList.size() > 0) ? dentistList.stream()
				.map((s) -> modelMapper.map(s, DentistServiceModel.class)).collect(Collectors.toList())
				: null;
	}

	@Override
	public DentistServiceModel getDentistById(Long id) {
		Dentist dentist = dentistRepository.getOne(id);
		return dentist !=null? modelMapper.map(dentist, DentistServiceModel.class): null;

	}

	@Override
	public DentistServiceModel addDentist(DentistServiceModel dentist) {
		Dentist persistanceEntity = modelMapper.map(dentist, Dentist.class);
		Dentist dentistsSavedEntity = dentistRepository.save(persistanceEntity);
		return modelMapper.map(dentistsSavedEntity, DentistServiceModel.class);
	}

	@Override
	public String processDentistImage(String imageName,MultipartFile file){
		String currentFileName =file.getResource().getFilename();
		String extension =currentFileName.substring(currentFileName.lastIndexOf(".")+1);
		String fullDentistImagePath = ProjectConstants.DENTIST_IMAGES_PATH +  imageName +"." + extension;
		FileOutputStream out;
		try {
			out = new FileOutputStream(fullDentistImagePath);
			out.write(file.getBytes());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		return fullDentistImagePath;
	}

}
