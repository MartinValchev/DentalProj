package com.spring.dental.proj.DentalProj.models;

import java.util.Date;
import java.util.List;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.entities.ExaminationImage;
import com.spring.dental.proj.DentalProj.entities.Patient;

public class MedicalExaminationServiceModel {
	private long id;

	private String title;
	
	private Dentist dentist;
	
	private Patient patient;

	private Date startDate;

	private Date endDate;

	private List<ExaminationImage> examinationImages;
	
	private String notes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Dentist getDentist() {
		return dentist;
	}

	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<ExaminationImage> getExaminationImages() {
		return examinationImages;
	}

	public void setExaminationImages(List<ExaminationImage> examinationImages) {
		this.examinationImages = examinationImages;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
