package com.spring.dental.proj.DentalProj.domain.models.binding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dental.proj.DentalProj.domain.models.service.view.DentistMedicalExaminationViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.ExaminationImageViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.PatientMedicalExaminationViewModel;
import com.spring.dental.proj.DentalProj.utils.Messages;

public class MedicalExaminationBindingModel {
	
	private String id;
		
	@NotBlank(message="Invalid title")
	@Size(min=2, max=100,message = Messages.TITLE_VALIDATION_MESSAGE)
	private String title;
	
	@NotNull(message = "You must select dentist")
	private DentistMedicalExaminationViewModel dentist = new DentistMedicalExaminationViewModel();
	
	@NotNull(message = "You must select patient")
	private PatientMedicalExaminationViewModel patient = new PatientMedicalExaminationViewModel();
    
    @NotNull(message = "Invalid Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "start date On date must be either in present or in future")
	private Date startDate;
    
    @NotNull(message = "Invalid Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Future(message = "end date On date must be in future")
	private Date endDate;

	private MultipartFile[] examinationImages;
	

	@NotBlank(message="Invalid notes ")
	@Size(min=2, max=1000,message = Messages.NOTES_VALIDATION_MESSAGE)
	private String notes;


	public String getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public DentistMedicalExaminationViewModel getDentist() {
		return dentist;
	}


	public PatientMedicalExaminationViewModel getPatient() {
		return patient;
	}


	public Date getStartDate() {
		return startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public MultipartFile[] getExaminationImages() {
		return examinationImages;
	}


	public String getNotes() {
		return notes;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setDentist(DentistMedicalExaminationViewModel dentist) {
		this.dentist = dentist;
	}


	public void setPatient(PatientMedicalExaminationViewModel patient) {
		this.patient = patient;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public void setExaminationImages(MultipartFile[] examinationImages) {
		this.examinationImages = examinationImages;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
