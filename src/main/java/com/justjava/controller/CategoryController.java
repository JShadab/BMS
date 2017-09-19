package com.justjava.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.justjava.model.Category;
import com.justjava.model.User;
import com.justjava.service.CategoryService;
import com.justjava.utils.KeyName;
import com.justjava.utils.PageName;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "addCategory.html")
	public String getAddCategoryPage(Model model, HttpSession session) {

		return populateCategories(model, session) ? PageName.ADD_CATEGORY : PageName.LOGIN;
	}

	@GetMapping(value = "viewEditDeleteCategory.html")
	public String getViewEditDeleteCategoryPage(Model model, HttpSession session) {

		return populateCategories(model, session) ? PageName.VIEW_EDIT_DELETE_CATEGORY : PageName.LOGIN;
	}

	@PostMapping(value = "addCategory")
	public String AddCategory(@ModelAttribute("category") Category category, Model model, HttpSession session) {

		categoryService.addCategotegory(category);

		return populateCategories(model, session) ? PageName.ADD_CATEGORY : PageName.LOGIN;

	}

	private boolean populateCategories(Model model, HttpSession session) {

		if (session == null) {
			return false;
		}
		User user = (User) session.getAttribute(KeyName.LOGIN_USER);

		if (user == null) {
			return false;
		}
		model.addAttribute("allCategories", categoryService.getAllCategories(user.getUserId()));

		return true;
	}
}
