package com.spring.dental.proj.DentalProj.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examination_images")
<<<<<<< HEAD:DentalProj/DentalProj/src/main/java/com/spring/dental/proj/DentalProj/entities/ExaminationImage.java
public class ExaminationImage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7252751511414345167L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
=======
public class ExaminationImage {
	@Id

	@GeneratedValue(strategy= GenerationType.IDENTITY)
>>>>>>> master:DentalProj/src/main/java/com/spring/dental/proj/DentalProj/entities/ExaminationImage.java
	private long id;
	
	@Column(name="image_name")
	private String imageName;
	
	@ManyToOne
	@JoinColumn(name="medical_examination_id")
	private MedicalExamination medicalExamination;
	
	@Column(name = "upload_date")
	private Date uploadDate;
	

	@Column(name = "image_path")
	private String imagePath;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public MedicalExamination getMedicalExamination() {
		return medicalExamination;
	}

	public void setMedicalExamination(MedicalExamination medicalExamination) {
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
