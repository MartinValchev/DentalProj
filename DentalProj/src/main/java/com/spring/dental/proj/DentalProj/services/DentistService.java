package com.spring.dental.proj.DentalProj.services;

import java.util.List;

import com.spring.dental.proj.DentalProj.entities.Dentist;

public interface DentistService {
	List<Dentist> getAllDentists();
	Dentist getDentistById(Long id);
	Dentist addDentist(Dentist dentist);
}
