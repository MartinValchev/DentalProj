package com.spring.dental.proj.DentalProj.domain.models.service.view;

import java.util.Date;

public class ExaminationImageViewModel  extends BaseViewModel{
	
private String imageName;
	
	private MedicalExaminationViewModel medicalExamination;
	
	private Date uploadDate;
	
	private String imagePath;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public MedicalExaminationViewModel getMedicalExamination() {
		return medicalExamination;
	}

	public void setMedicalExamination(MedicalExaminationViewModel medicalExamination) {
		this.medicalExamination = medicalExamination;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
