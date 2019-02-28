package com.spring.entities;

import java.util.Date;
import java.util.List;

public class MedicalExamination {
	private long id;
	private String title;
	private Patient patient;
	private Date startDate;
	private Date endDate;
	private List<ExaminationImages> examinationImages;
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
	public List<ExaminationImages> getExaminationImages() {
		return examinationImages;
	}
	public void setExaminationImages(List<ExaminationImages> examinationImages) {
		this.examinationImages = examinationImages;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
