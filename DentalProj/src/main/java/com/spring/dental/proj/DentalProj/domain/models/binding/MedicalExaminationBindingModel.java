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
	
	@NotBlank(message="Invalid name")
	@Size(min=2, max=40,message = Messages.FIRST_NAME_VALIDATION_MESSAGE)
	private String dentistFirstName;
	
	@NotBlank(message="Invalid name")
	@Size(min=2, max=40,message = Messages.MIDDLE_NAME_VALIDATION_MESSAGE)
	private String dentistMiddleName;
	
	@NotBlank(message="Invalid name")
	@Size(min=2, max=40,message = Messages.LAST_NAME_VALIDATION_MESSAGE)
	private String dentistLastName;	
	
	private String dentistImagePath;
	
    @NotBlank(message="Invalid name")
	@Size(min=2, max=40,message = Messages.FIRST_NAME_VALIDATION_MESSAGE)
	private String patientFirstName;

	@NotBlank(message="Invalid name")
	@Size(min=2, max=40,message = Messages.MIDDLE_NAME_VALIDATION_MESSAGE)
	private String patientMiddleName;

	@NotBlank(message="Invalid name")
	@Size(min=2, max=40,message = Messages.LAST_NAME_VALIDATION_MESSAGE)
	private String patientLastName;

	private String patientImagePath;

	private Date startDate;

	private Date endDate;

	private List<ExaminationImageViewModel> examinationImages;
	

	@NotBlank(message="Invalid title")
	@Size(min=2, max=100,message = Messages.TITLE_VALIDATION_MESSAGE)
	private String notes;
	
	

}
