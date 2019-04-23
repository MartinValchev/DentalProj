package com.spring.dental.proj.DentalProj.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.spring.dental.proj.DentalProj.domain.models.PatientServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.PatientMedicalExaminationViewModel;
import com.spring.dental.proj.DentalProj.service.PatientService;

import javassist.NotFoundException;

@Component
public class PatientConverter implements Converter<String, PatientMedicalExaminationViewModel> {

	@Autowired
	PatientService patientService;

	@Override
	public PatientMedicalExaminationViewModel convert(String id) {
		PatientMedicalExaminationViewModel patient = new PatientMedicalExaminationViewModel();
		StringBuilder fullPatientName = new StringBuilder();
		try {
			PatientServiceModel patientServiceModel = patientService.getPatientById(id);
			fullPatientName.append(patientServiceModel.getFirstName()).append(patientServiceModel.getMiddleName())
					.append(patientServiceModel.getLastName());
		} catch (NotFoundException e) {
			// TODO throw patient not found exception
		}

		patient.setId(id);
		patient.setPatientFullName(fullPatientName.toString());
		return patient;
	}

}
