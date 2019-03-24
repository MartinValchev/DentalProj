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

import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.PatientServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.DentistBindingModel;
import com.spring.dental.proj.DentalProj.service.PatientService;

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
	public String addDentist(@Valid @ModelAttribute DentistBindingModel dentistBindingModel, BindingResult bindingResult, Model model,@RequestParam("dentistImage") MultipartFile dentistImage) {
		  if(bindingResult.hasErrors()){

	            model.addAttribute("dentistBindingModel",dentistBindingModel);
	            return "addDentist";
	        }else{
	        	if(!dentistImage.isEmpty()) {
	        		String dentistImageName = dentistBindingModel.getFirstName() + "_" + dentistBindingModel.getMiddleName()  + "_" +  dentistBindingModel.getLastName();
	        		String fullDentistImagePath = dentistService.processDentistImage(dentistImageName, dentistImage);
	        		dentistBindingModel.setDentistImagePath(fullDentistImagePath);
	        	}
	        	DentistServiceModel dentistServiceModel =  modelMapper.map(dentistBindingModel, DentistServiceModel.class);
	            DentistServiceModel savedDentist = dentistService.addDentist(dentistServiceModel);
	            return "redirect:/dentist/" +  savedDentist.getId();
	        }
	}
	
	
}
