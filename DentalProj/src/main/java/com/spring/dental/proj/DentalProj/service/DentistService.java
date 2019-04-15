package com.spring.dental.proj.DentalProj.service;

import java.util.List;

import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;

import javassist.NotFoundException;

public interface DentistService {
	List<DentistServiceModel> getAllDentists()throws NotFoundException;
	DentistServiceModel getDentistById(String id);
	DentistServiceModel addDentist(DentistServiceModel dentist);
	DentistServiceModel editDentist(DentistServiceModel dentist);
	void removeDentist(DentistServiceModel dentist) throws NotFoundException;
	
}
