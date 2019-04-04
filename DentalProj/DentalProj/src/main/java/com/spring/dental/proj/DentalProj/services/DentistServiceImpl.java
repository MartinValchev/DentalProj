package com.spring.dental.proj.DentalProj.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.models.DentistServiceModel;
import com.spring.dental.proj.DentalProj.repositories.DentistRepository;

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
		Dentist dentist = dentistRepository.getDentistById(id);
		return dentist !=null? modelMapper.map(dentist, DentistServiceModel.class): null;

	}

	@Override
	public DentistServiceModel addDentist(DentistServiceModel dentist) {
		Dentist persistanceEntity = modelMapper.map(dentist, Dentist.class);
		Dentist dentistsSavedEntity = dentistRepository.save(persistanceEntity);
		return modelMapper.map(dentistsSavedEntity, DentistServiceModel.class);
	}

}
