package com.spring.dental.proj.DentalProj.services;

import java.util.List;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.models.DentistServiceModel;

public interface DentistService {
	List<DentistServiceModel> getAllDentists();
	DentistServiceModel getDentistById(Long id);
	DentistServiceModel addDentist(DentistServiceModel dentist);
}
