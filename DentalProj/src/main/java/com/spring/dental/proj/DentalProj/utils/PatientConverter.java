package com.spring.dental.proj.DentalProj.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.spring.dental.proj.DentalProj.domain.models.service.view.PatientMedicalExaminationViewModel;

@Component
public class PatientConverter implements Converter<String,PatientMedicalExaminationViewModel>{

	@Override
	public PatientMedicalExaminationViewModel convert(String id) {
		PatientMedicalExaminationViewModel patient = new PatientMedicalExaminationViewModel();
		patient.setId(id);
		return patient;
	}

}
