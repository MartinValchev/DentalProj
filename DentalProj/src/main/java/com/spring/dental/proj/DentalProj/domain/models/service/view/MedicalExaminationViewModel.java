package com.spring.dental.proj.DentalProj.domain.models.service.view;

import java.util.Date;
import java.util.List;

public class MedicalExaminationViewModel extends BaseViewModel{
	
	public MedicalExaminationViewModel() {}
	
	private String title;
	
	private DentistMedicalExaminationViewModel dentist;
	
	private PatientMedicalExaminationViewModel patient;

	private Date startDate;

	private Date endDate;

	private List<ExaminationImageViewModel> examinationImages;
	
	private String notes;

	public String getTitle() {
		return title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public List<ExaminationImageViewModel> getExaminationImages() {
		return examinationImages;
	}

	public String getNotes() {
		return notes;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setExaminationImages(List<ExaminationImageViewModel> examinationImages) {
		this.examinationImages = examinationImages;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public DentistMedicalExaminationViewModel getDentist() {
		return dentist;
	}

	public PatientMedicalExaminationViewModel getPatient() {
		return patient;
	}

	public void setDentist(DentistMedicalExaminationViewModel dentist) {
		this.dentist = dentist;
	}

	public void setPatient(PatientMedicalExaminationViewModel patient) {
		this.patient = patient;
	}
	
	
}
