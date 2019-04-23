package com.spring.dental.proj.DentalProj.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.spring.dental.proj.DentalProj.domain.models.service.view.DentistMedicalExaminationViewModel;

@Component
public class DentistConverter implements Converter<String,DentistMedicalExaminationViewModel>{

	@Override
	public DentistMedicalExaminationViewModel convert(String id) {
		DentistMedicalExaminationViewModel dentist = new DentistMedicalExaminationViewModel();
		dentist.setId(id);
		return dentist;
	}

}
