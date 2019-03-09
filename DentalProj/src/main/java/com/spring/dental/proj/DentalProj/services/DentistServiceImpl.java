package com.spring.dental.proj.DentalProj.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.repositories.DentistRepository;

@Service
public class DentistServiceImpl implements DentistService {

	@Autowired
	DentistRepository dentistRepository;

	@Override
	public List<Dentist> getAllDentists() {
		return dentistRepository.findAll();
	}

	@Override
	public Dentist getDentistById(Long id) {
		return dentistRepository.getOne(id);
	}

	@Override
	public Dentist addDentist(Dentist dentist) {
		return dentistRepository.save(dentist);
	}

}
