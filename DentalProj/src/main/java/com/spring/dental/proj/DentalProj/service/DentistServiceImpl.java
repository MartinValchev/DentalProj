package com.spring.dental.proj.DentalProj.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.DentalProj.domain.entities.Dentist;
import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;
import com.spring.dental.proj.DentalProj.domain.repository.DentistRepository;

@Service
public class DentistServiceImpl implements DentistService {

	@Autowired
	DentistRepository dentistRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<DentistServiceModel> getAllDentists() {
		List<Dentist> dentistList = dentistRepository.findAll();
		return dentistList.stream().map((s) -> modelMapper.map(s, DentistServiceModel.class))
				.collect(Collectors.toList());
	}

	@Override
	public DentistServiceModel getDentistById(String id) {
		Dentist dentist = dentistRepository.findById(id).orElseThrow(() -> new NotFoundException());
		return modelMapper.map(dentist, DentistServiceModel.class);

	}

	@Override
	public DentistServiceModel addDentist(DentistServiceModel dentist) {
		Dentist persistanceEntity = modelMapper.map(dentist, Dentist.class);
		Dentist dentistsSavedEntity = dentistRepository.save(persistanceEntity);
		return modelMapper.map(dentistsSavedEntity, DentistServiceModel.class);
	}

	@Override
	public DentistServiceModel editDentist(DentistServiceModel dentist) {
		Dentist persistanceEntity = modelMapper.map(dentist, Dentist.class);
		Dentist dentistsSavedEntity = dentistRepository.save(persistanceEntity);
		return modelMapper.map(dentistsSavedEntity, DentistServiceModel.class);
	}

}
