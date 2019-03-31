package com.spring.dental.proj.DentalProj.service;

import java.util.List;

import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;

public interface DentistService {
	List<DentistServiceModel> getAllDentists();
	DentistServiceModel getDentistById(String id);
	DentistServiceModel addDentist(DentistServiceModel dentist);
	DentistServiceModel editDentist(DentistServiceModel dentist);
	
}
