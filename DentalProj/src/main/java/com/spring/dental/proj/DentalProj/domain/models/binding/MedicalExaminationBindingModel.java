package com.spring.dental.proj.DentalProj.domain.models.binding;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.spring.dental.proj.DentalProj.domain.models.service.view.AllDentistsViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.AllPatientsViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.ExaminationImageViewModel;
import com.spring.dental.proj.DentalProj.utils.Messages;

public class MedicalExaminationBindingModel {
	
	private String id;
	
	
	@NotBlank(message="Invalid title")
	@Size(min=2, max=100,message = Messages.TITLE_VALIDATION_MESSAGE)
	private String title;
	
	private String dentistFirstName;
	
	private String dentistMiddleName;
	
	private String dentistFastName;	
	
	private String dentistImagePath;
	
	private String patientFirstName;

	private String patientMiddleName;

	private String patientLastName;

	private String patientImagePath;

	private Date startDate;

	private Date endDate;

	private List<ExaminationImageViewModel> examinationImages;
	
	private String notes;

}
