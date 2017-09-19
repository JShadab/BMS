package com.justjava.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.justjava.model.Manufacturer;
import com.justjava.model.User;
import com.justjava.service.ManufacturerService;
import com.justjava.utils.KeyName;
import com.justjava.utils.PageName;

@Controller
public class ManufacturerController {

	@Autowired
	private ManufacturerService manufacturerService;

	/** calls when user clicks on add manufacturer menu under store option */
	@GetMapping(value = "addManufacturer.html")
	public String getAddManufacturerPage(HttpSession session) {

		User user = (User) session.getAttribute(KeyName.LOGIN_USER);

		return user == null ? PageName.LOGIN : PageName.ADD_MANUFACTURER;
	}
	

	@PostMapping(value = "addManufacturer")
	public String AddCategory(@ModelAttribute("manufacturer") Manufacturer manufacturer, Model model, HttpSession session) {

		manufacturerService.addManufacture(manufacturer);

		return populateManufactures(model, session) ? PageName.ADD_CATEGORY : PageName.LOGIN;

	}
	
	
	@GetMapping(value = "viewEditDeleteManufacturer.html")
	public String getViewEditDeleteCategoryPage(Model model, HttpSession session) {

		return populateManufactures(model, session) ? PageName.VIEW_EDIT_DELETE_MANUFACTURER : PageName.LOGIN;
	}
	private boolean populateManufactures(Model model, HttpSession session) {

		if (session == null) {
			return false;
		}
		User user = (User) session.getAttribute(KeyName.LOGIN_USER);

		if (user == null) {
			return false;
		}
		model.addAttribute(KeyName.ALL_MANUFACTURERS, manufacturerService.getAllManufacturers(user.getUserId()));

		return true;
	}

}
