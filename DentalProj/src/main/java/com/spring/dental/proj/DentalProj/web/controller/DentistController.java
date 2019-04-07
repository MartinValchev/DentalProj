package com.spring.dental.proj.DentalProj.web.controller;

import java.util.List;

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

import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.DentistBindingModel;
import com.spring.dental.proj.DentalProj.service.DentistService;
import com.spring.dental.proj.DentalProj.utils.CommonService;
import com.spring.dental.proj.DentalProj.utils.ProjectConstants;


@Controller
@RequestMapping("/dentist")
@PreAuthorize("isAuthenticated()")
public class DentistController extends BaseController{

	@Autowired
	DentistService dentistService;
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/all")
	public ModelAndView getDentistList(ModelAndView modelAndView) {
		List<DentistServiceModel> dentsitList = dentistService.getAllDentists();
		modelAndView.addObject("dentistList", dentsitList);
		modelAndView.setViewName("dentistList");
		return modelAndView;
	}
	
	@GetMapping("/get/{id}")
	public ModelAndView getDentistById(ModelAndView modelAndView, @PathVariable("id") Long id) {
	/*	DentistServiceModel dentistServiceModel = dentistService.getDentistById(id);
		modelAndView.addObject("dentist", dentistServiceModel);
		modelAndView.setViewName("dentist");*/
		return modelAndView;
	}
	
	@PostMapping("/add")
	public ModelAndView addDentist(@Valid @ModelAttribute DentistBindingModel dentistBindingModel, BindingResult bindingResult, Model model,@RequestParam("dentistImage") MultipartFile dentistImage) {
		  if(bindingResult.hasErrors()){

	            model.addAttribute("dentistBindingModel",dentistBindingModel);
	            return super.view("addDentist");
	        }else{
	        	if(!dentistImage.isEmpty()) {
	        		String dentistImageName = dentistBindingModel.getFirstName() + "_" + dentistBindingModel.getMiddleName()  + "_" +  dentistBindingModel.getLastName();
	        		String fullDentistImagePath = commonService.processModelImage(ProjectConstants.DENTIST_MODEL, dentistImageName, dentistImage);
	        		dentistBindingModel.setDentistImagePath(fullDentistImagePath);
	        	}
	        	DentistServiceModel dentistServiceModel =  modelMapper.map(dentistBindingModel, DentistServiceModel.class);
	            DentistServiceModel savedDentist = dentistService.addDentist(dentistServiceModel);
	            return super.view("redirect:/dentist/" +  savedDentist.getId());
	        }
	}
		@GetMapping("/add")
		public ModelAndView getAddDentistPage(DentistBindingModel dentistBindingModel, Model model) {
			
			return super.view("addDentist");
		}
	
	}
