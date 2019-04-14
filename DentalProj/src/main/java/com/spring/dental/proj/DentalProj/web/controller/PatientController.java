package com.spring.dental.proj.DentalProj.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dental.proj.DentalProj.domain.models.PatientServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.PatientBindingModel;
import com.spring.dental.proj.DentalProj.service.PatientService;
import com.spring.dental.proj.DentalProj.utils.CommonService;
import com.spring.dental.proj.DentalProj.utils.ProjectConstants;

@Controller
public class PatientController {
 /*
  * List<PatientServiceModel> getAllPatients();

	PatientServiceModel getPatientById(Long id);

	PatientServiceModel addNewPatient(PatientServiceModel patient);
	
	PatientServiceModel editPatient(PatientServiceModel patient);
  */
	@Autowired
	PatientService patientService;
	
	@Autowired
	CommonService commonService;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/patients")
	public ModelAndView getAllPatientsList(ModelAndView modelAndView) {
		List<PatientServiceModel> patientsList = patientService.getAllPatients();
		modelAndView.addObject("patientList", patientsList);
		modelAndView.setViewName("patientList");
		return modelAndView;
	}
	
	@GetMapping("/patient/{id}")
	public ModelAndView getPatientById(@PathVariable("id") Long id,ModelAndView modelAndView) {
		PatientServiceModel patient = patientService.getPatientById(id);
		modelAndView.addObject("patient", patient);
		modelAndView.setViewName("patientById");
		return modelAndView;
	}
	
	@PostMapping("/patient/add")
	public String addPatient(@Valid @ModelAttribute PatientBindingModel patientBindingModel, BindingResult bindingResult, Model model,@RequestParam("patientImage") MultipartFile patientImage) {
		  if(bindingResult.hasErrors()){

	            model.addAttribute("patientBindingModel",patientBindingModel);
	            return "addPatient";
	        }else{
	        	if(!patientImage.isEmpty()) {
	        		String patientImageName = patientBindingModel.getFirstName() + "_" + patientBindingModel.getMiddleName()  + "_" +  patientBindingModel.getLastName();
	        		String fullPatientImagePath = commonService.storeModelImage(ProjectConstants.PATIENT_MODEL,patientImageName, patientImage);
	        		String relativePatientImagePath = commonService.generateRelativeImagePath(fullPatientImagePath, ProjectConstants.PATIENT_MODEL);
	        		patientBindingModel.setPatientImagePath(relativePatientImagePath);
	        	}
	        	PatientServiceModel patientServiceModel =  modelMapper.map(patientBindingModel, PatientServiceModel.class);
	        	PatientServiceModel savedPatient = patientService.addNewPatient(patientServiceModel);
	            return "redirect:/patient/" +  savedPatient.getId();
	        }
	}
	
	@PostMapping("/patient/edit")
	public String editPatient(@Valid @ModelAttribute PatientBindingModel patientBindingModel, BindingResult bindingResult, Model model,@RequestParam("patientImage") MultipartFile patientImage) {
		  if(bindingResult.hasErrors()){

	            model.addAttribute("patientBindingModel",patientBindingModel);
	            return "editPatient";
	        }else{
	        	if(!patientImage.isEmpty()) {
	        		String patientImageName = patientBindingModel.getFirstName() + "_" + patientBindingModel.getMiddleName()  + "_" +  patientBindingModel.getLastName();
	        		String fullPatientImagePath = commonService.storeModelImage(ProjectConstants.PATIENT_MODEL,patientImageName, patientImage);
	        		String relativeImagePath = commonService.generateRelativeImagePath(fullPatientImagePath, ProjectConstants.PATIENT_MODEL);
	        		patientBindingModel.setPatientImagePath(relativeImagePath);
	        	}
	        	PatientServiceModel patientServiceModel =  modelMapper.map(patientBindingModel, PatientServiceModel.class);
	        	PatientServiceModel savedPatient = patientService.addNewPatient(patientServiceModel);
	            return "redirect:/patient/" +  savedPatient.getId();
	        }
	}
	
}
