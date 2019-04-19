package com.spring.dental.proj.DentalProj.utils;

public class ProjectConstants {
	// image paths
	public static final String DENTIST_IMAGES_PATH = "C:\\Projects\\DentalProj\\dentist\\images\\";
	//public static final String DENTIST_IMAGES_PATH = "E:\\Projects2\\DentalProj\\dentist\\images\\";
	
	
	//public static final String PATIENT_IMAGES_PATH = "E:\\Projects2\\DentalProj\\patient\\images\\";
	public static final String PATIENT_IMAGES_PATH = "C:\\Projects\\DentalProj\\patient\\images\\";
	
	public static final String MEDICAL_EXAMINATION_IMAGES_PATH = "C:\\Projects\\DentalProj\\examination\\images\\";
		
	public static final String DENTIST_IMAGES_MAPPED_PATH = "/dentist/images/";
	
	public static final String PATIENT_IMAGES_MAPPED_PATH = "/patient/images/";
	
	public static final String MEDICAL_EXAMINATION_IMAGES_MAPPED_PATH = "/examination/images/";
	
	
	// regex expressions
	public static final String TELEPHONE_REGEX_VALIDATION ="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\.\\/0-9]*$";
	
	// model constants
	public static final String DENTIST_MODEL ="DENTIST";
	
	public static final String PATIENT_MODEL ="PATIENT";
	
	public static final String MEDICAL_EXAMINATION_MODEL ="EXAMINATION";
}
