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
import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.DentistBindingModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.AllDentistsViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.DentistViewModel;
import com.spring.dental.proj.DentalProj.service.DentistService;
import com.spring.dental.proj.DentalProj.utils.CommonService;
import com.spring.dental.proj.DentalProj.utils.ProjectConstants;

@Controller
@RequestMapping("/dentist")
@PreAuthorize("isAuthenticated()")
public class DentistController extends BaseController {

	@Autowired
	DentistService dentistService;

	@Autowired
	CommonService commonService;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/get/{id}")
	public ModelAndView getDentistById(ModelAndView modelAndView, @PathVariable("id") String id) {
		DentistServiceModel dentistServiceModel = dentistService.getDentistById(id);
		DentistViewModel dentistViewModel = this.modelMapper.map(dentistServiceModel, DentistViewModel.class);
		String relativeImagePath = commonService.generateRelativeImagePath(dentistViewModel.getDentistImagePath(),ProjectConstants.DENTIST_MODEL);
		dentistViewModel.setDentistImagePath(relativeImagePath);
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
	public ModelAndView addDentist(@Valid @ModelAttribute DentistBindingModel dentistBindingModel,
			BindingResult bindingResult, Model model, @RequestParam("dentistImage") MultipartFile dentistImage) {
		if (bindingResult.hasErrors()) {

			model.addAttribute("dentistBindingModel", dentistBindingModel);
			return super.view("addDentist");
		} else {
			commonService.updateDentistsImagePath(dentistBindingModel, dentistImage);
			DentistServiceModel dentistServiceModel = modelMapper.map(dentistBindingModel, DentistServiceModel.class);
			Address address = new Address();
			address.setAddressLine1(dentistBindingModel.getAddressLine1());
			address.setAddressLine2(dentistBindingModel.getAddressLine2());
			address.setCity(dentistBindingModel.getCity());
			address.setCountry(dentistBindingModel.getCountry());
			address.setPostCode(dentistBindingModel.getPostCode());
			dentistServiceModel.setAddress(address);
			DentistServiceModel savedDentist = dentistService.addDentist(dentistServiceModel);
			return super.redirect("/dentist/get/" + savedDentist.getId());
		}
	}

	@GetMapping("/add")
	public ModelAndView getAddDentistPage(DentistBindingModel dentistBindingModel, Model model) {

		return super.view("addDentist");
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView getAllDentistsPage(ModelAndView modelAndView) {			
		List<AllDentistsViewModel> dentists = this.dentistService.getAllDentists()
				.stream()
				.map(r -> {
		    AllDentistsViewModel model = this.modelMapper.map(r, AllDentistsViewModel.class);
		    if(null != model.getDentistImagePath()) {
				String imagePath = model.getDentistImagePath();
				String imageName = imagePath.substring(imagePath.lastIndexOf('\\')+1);
				String relativeImagePath = ProjectConstants.DENTIST_IMAGES_MAPPED_PATH + imageName;
				model.setDentistImagePath(relativeImagePath);
		    }
			return model;	})
				.collect(Collectors.toList());
		modelAndView.addObject("dentists", dentists);
		return super.view("dentistList", modelAndView);
	}
	@GetMapping("/edit/{id}")
	public ModelAndView getEditPage(@PathVariable("id")String id,DentistBindingModel dentistBindingModel, ModelAndView modelAndView) {
		DentistServiceModel model = this.dentistService.getDentistById(id);
		if(model !=null) {
		dentistBindingModel = modelMapper.map(model, DentistBindingModel.class);
		dentistBindingModel.setAddressLine1(model.getAddress().getAddressLine1());
		dentistBindingModel.setAddressLine2(model.getAddress().getAddressLine2());
		dentistBindingModel.setCity(model.getAddress().getCity());
		dentistBindingModel.setCountry(model.getAddress().getCountry());
		dentistBindingModel.setPostCode(model.getAddress().getPostCode());
		String relativeImagePath = commonService.generateRelativeImagePath(dentistBindingModel.getDentistImagePath(),ProjectConstants.DENTIST_MODEL);
		dentistBindingModel.setDentistImagePath(relativeImagePath);
		modelAndView.addObject("dentistBindingModel", dentistBindingModel);
		return super.view("editDentist",modelAndView);
		}else {
			return super.view("");
		}
	
	}
	@PostMapping("/edit")
	public ModelAndView editDentsit(@Valid @ModelAttribute DentistBindingModel dentistBindingModel,
			BindingResult bindingResult, Model model, @RequestParam("dentistImage") MultipartFile dentistImage) {
		if (bindingResult.hasErrors()) {

			model.addAttribute("dentistBindingModel", dentistBindingModel);
			return super.view("editDentist");
		} else {
			dentistBindingModel = commonService.updateDentistsImagePath(dentistBindingModel, dentistImage);
			DentistServiceModel dentistServiceModel = modelMapper.map(dentistBindingModel, DentistServiceModel.class);
			Address address = new Address();
			address.setAddressLine1(dentistBindingModel.getAddressLine1());
			address.setAddressLine2(dentistBindingModel.getAddressLine2());
			address.setCity(dentistBindingModel.getCity());
			address.setCountry(dentistBindingModel.getCountry());
			address.setPostCode(dentistBindingModel.getPostCode());
			dentistServiceModel.setAddress(address);
			DentistServiceModel savedDentist = dentistService.addDentist(dentistServiceModel);
			return super.redirect("/dentist/get/" + savedDentist.getId());
		}
	}
	
}
