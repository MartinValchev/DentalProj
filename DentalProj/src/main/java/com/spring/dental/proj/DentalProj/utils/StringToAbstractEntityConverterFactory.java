package com.spring.dental.proj.DentalProj.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.spring.dental.proj.DentalProj.domain.models.service.view.BaseViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.DentistMedicalExaminationViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.PatientMedicalExaminationViewModel;
import com.spring.dental.proj.DentalProj.service.DentistService;
import com.spring.dental.proj.DentalProj.service.PatientService;

public class StringToAbstractEntityConverterFactory implements ConverterFactory<String, BaseViewModel> {

	DentistService dentistService;

	PatientService patientService;

	@Autowired
	public StringToAbstractEntityConverterFactory(DentistService dentistService, PatientService patientService) {
		this.dentistService = dentistService;
		this.patientService = patientService;
	}

	@Override
	public <T extends BaseViewModel> Converter<String, T> getConverter(Class<T> targetClass) {
		return new StringToAbstractEntityConverter<>(targetClass);
	}

	private static class StringToAbstractEntityConverter<T extends BaseViewModel> implements Converter<String, T> {

		private Class<T> targetClass;

		public StringToAbstractEntityConverter(Class<T> targetClass) {
			this.targetClass = targetClass;
		}

		@Override
	        public T convert(String id) {
	            if(this.targetClass == DentistMedicalExaminationViewModel.class) {
	            	DentistMedicalExaminationViewModel model = new DentistMedicalExaminationViewModel();
	            	model.setId(id);
	            	return (T) model;
	            }
	            else if(this.targetClass == PatientMedicalExaminationViewModel.class) {
	            	PatientMedicalExaminationViewModel model = new PatientMedicalExaminationViewModel();
	            	model.setId(id);
	                return (T) model;
	            } else {
	                return null;
	            }
	        }
	}

}
