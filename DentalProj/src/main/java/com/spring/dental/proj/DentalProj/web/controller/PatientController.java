package com.spring.dental.proj.DentalProj.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.spring.dental.proj.DentalProj.domain.entities.Address;
import com.spring.dental.proj.DentalProj.domain.models.PatientServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.PatientBindingModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.AllPatientsViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.DentistViewModel;
import com.spring.dental.proj.DentalProj.service.PatientService;
import com.spring.dental.proj.DentalProj.utils.CommonService;
import com.spring.dental.proj.DentalProj.utils.ProjectConstants;

import javassist.NotFoundException;

@Controller
@RequestMapping("/patient")
public class PatientController extends BaseController {

	@Autowired
	PatientService patientService;
	
	@Autowired
	CommonService commonService;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView getAllPatientsPage(ModelAndView modelAndView) {			
		List<AllPatientsViewModel> patients =null;
			patients = this.patientService.getAllPatients()
					.stream()
					.map(r -> {
						AllPatientsViewModel model = this.modelMapper.map(r, AllPatientsViewModel.class);
				return model;	})
					.collect(Collectors.toList());
		modelAndView.addObject("patients", patients);
		return super.view("allPatients", modelAndView);
	}

	@GetMapping("/get/{id}")
	public ModelAndView getDentistById(ModelAndView modelAndView, @PathVariable("id") String id) throws NotFoundException {
		PatientServiceModel dentistServiceModel = patientService.getPatientById(id);
		DentistViewModel dentistViewModel = this.modelMapper.map(dentistServiceModel, DentistViewModel.class);
		Address address = dentistServiceModel.getAddress();
		dentistViewModel.setAddressLine1(address.getAddressLine1());
		dentistViewModel.setAddressLine2(address.getAddressLine2());
		dentistViewModel.setCity(address.getCity());
		dentistViewModel.setCountry(address.getCountry());
		dentistViewModel.setPostCode(address.getPostCode());
		modelAndView.addObject("dentist", dentistViewModel);
		modelAndView.setViewName("dentist");
		return super.view("dentist", modelAndView);
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView addPatient(@Valid @ModelAttribute PatientBindingModel patientBindingModel, BindingResult bindingResult, Model model,@RequestParam("patientImage") MultipartFile patientImage) {
		if (bindingResult.hasErrors()) {

			model.addAttribute("patientBindingModel", patientBindingModel);
			return super.view("addPatient");
		} else {
			String patientImageName = patientBindingModel.getFirstName() + "_" +
					patientBindingModel.getMiddleName() + "_" +patientBindingModel.getLastName();
			String fullImagePath  = commonService.storeModelImage(ProjectConstants.PATIENT_MODEL, patientImageName, patientImage);
			String relativeImagePath = commonService.generateRelativeImagePath(fullImagePath, ProjectConstants.PATIENT_MODEL);
			PatientServiceModel patientServiceModel = modelMapper.map(patientBindingModel, PatientServiceModel.class);
			patientServiceModel.setPatientImagePath(relativeImagePath);
			Address address = new Address();
			address.setAddressLine1(patientBindingModel.getAddressLine1());
			address.setAddressLine2(patientBindingModel.getAddressLine2());
			address.setCity(patientBindingModel.getCity());
			address.setCountry(patientBindingModel.getCountry());
			address.setPostCode(patientBindingModel.getPostCode());
			patientServiceModel.setAddress(address);
			PatientServiceModel savedPatient = patientService.addPatient(patientServiceModel);
			return super.redirect("/patient/get/" + savedPatient.getId());
		}
	}
	
	@GetMapping("/add")
	public ModelAndView getAddDentistPage(PatientBindingModel patientBindingModel, Model model) {
		return super.view("addPatient");
	}
	
	@PostMapping("/edit")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	        	PatientServiceModel savedPatient = patientService.addPatient(patientServiceModel);
	            return "redirect:/patient/" +  savedPatient.getId();
	        }
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getEditPage(@PathVariable("id")String id,PatientBindingModel patientBindingModel, ModelAndView modelAndView) throws NotFoundException {
		PatientServiceModel model = this.patientService.getPatientById(id);
		if(model !=null) {
		patientBindingModel = modelMapper.map(model, PatientBindingModel.class);
		patientBindingModel.setAddressLine1(model.getAddress().getAddressLine1());
		patientBindingModel.setAddressLine2(model.getAddress().getAddressLine2());
		patientBindingModel.setCity(model.getAddress().getCity());
		patientBindingModel.setCountry(model.getAddress().getCountry());
		patientBindingModel.setPostCode(model.getAddress().getPostCode());
		modelAndView.addObject("patientBindingModel", patientBindingModel);
		return super.view("editPatient",modelAndView);
		}else {
			return super.view("");
		}
	
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView getDeletePage(@PathVariable("id")String id,PatientBindingModel patientBindingModel, ModelAndView modelAndView) throws NotFoundException {
		PatientServiceModel model = this.patientService.getPatientById(id);
		if(model !=null) {
		patientBindingModel = modelMapper.map(model, PatientBindingModel.class);
		patientBindingModel.setAddressLine1(model.getAddress().getAddressLine1());
		patientBindingModel.setAddressLine2(model.getAddress().getAddressLine2());
		patientBindingModel.setCity(model.getAddress().getCity());
		patientBindingModel.setCountry(model.getAddress().getCountry());
		patientBindingModel.setPostCode(model.getAddress().getPostCode());
		modelAndView.addObject("patientBindingModel", patientBindingModel);
		return super.view("deletePatient",modelAndView);
		}else {
			return super.view("");
		}
	}
	
	@PostMapping("/delete")
	public ModelAndView deletePatient(@Valid @ModelAttribute PatientBindingModel patientBindingModel,
			 Model model) {
			
			PatientServiceModel patientServiceModel = modelMapper.map(patientBindingModel, PatientServiceModel.class);
			try {
				patientService.removePatient(patientServiceModel);
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
			return super.redirect("/patient/all");
	}
	
}
