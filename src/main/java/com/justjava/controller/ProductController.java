package com.justjava.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.justjava.model.Category;
import com.justjava.model.Manufacturer;
import com.justjava.model.Product;
import com.justjava.model.User;
import com.justjava.service.CategoryService;
import com.justjava.service.ManufacturerService;
import com.justjava.service.ProductService;
import com.justjava.utils.KeyName;
import com.justjava.utils.PageName;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ManufacturerService manufacturerService;

	@GetMapping(value = "viewEditDeleteProduct.html")
	public String getViewEditDeleteProductPage(Model model, HttpSession session) {

		User user = (User) session.getAttribute(KeyName.LOGIN_USER);

		if (user == null) {
			return PageName.LOGIN;
		}

		Long creatorId = user.getUserId();

		Set<Product> allProducts = productService.getAllProducts(creatorId);

		model.addAttribute(KeyName.ALL_PRODUCTS, allProducts);

		return PageName.VIEW_EDIT_DELETE_PRODUCT;

	}

	@GetMapping(value = "viewEditDeleteProduct.html/{categoryId}")
	public String getViewEditDeleteProductPageByCategory(@PathVariable Long categoryId, Model model,
			HttpSession session) {

		User user = (User) session.getAttribute(KeyName.LOGIN_USER);

		if (user == null) {
			return PageName.LOGIN;
		}

		Long creatorId = user.getUserId();

		Set<Product> allProducts = productService.getAllProductsByCategory(creatorId, categoryId);

		model.addAttribute(KeyName.ALL_PRODUCTS, allProducts);

		return PageName.VIEW_EDIT_DELETE_PRODUCT;

	}

	/** calls when user clicks on add product menu under store option */
	@GetMapping(value = "addProduct.html")
	public String getAddProductPage(Model model, HttpSession session) {

		User user = (User) session.getAttribute(KeyName.LOGIN_USER);

		Set<Category> allCategories = categoryService.getAllCategories(user.getUserId());
		Set<Manufacturer> allManufacturers = manufacturerService.getAllManufacturers(user.getUserId());

		model.addAttribute(KeyName.ALL_CATEGORIES, allCategories);
		model.addAttribute(KeyName.ALL_MANUFACTURERS, allManufacturers);

		return PageName.ADD_PRODUCT;
	}

	/** calls when user view categories and clicks on add product option */
	@GetMapping(value = "addProduct/{categoryName}")
	public String getAddProductPageWithCategory(@PathVariable String categoryName, Model model, HttpSession session) {

		model.addAttribute(KeyName.CATEGORY_NAME, categoryName);

		User user = (User) session.getAttribute(KeyName.LOGIN_USER);

		Set<Category> allCategories = categoryService.getAllCategories(user.getUserId());
		Set<Manufacturer> allManufacturers = manufacturerService.getAllManufacturers(user.getUserId());

		model.addAttribute(KeyName.ALL_CATEGORIES, allCategories);
		model.addAttribute(KeyName.ALL_MANUFACTURERS, allManufacturers);

		return PageName.ADD_PRODUCT;
	}

	/** calls when user view categories and clicks on add product option */
	@PostMapping(value = "addProduct")
	public String addProduct(@ModelAttribute("product") Product product, BindingResult result, HttpSession session) {

		User user = (User) session.getAttribute(KeyName.LOGIN_USER);

		if (user == null) {
			return PageName.LOGIN;
		}

		Long creatorId = user.getUserId();

		product.setCreatorId(creatorId);

		productService.addProduct(product);

		return PageName.ADD_PRODUCT;
	}

	/** calls when user view categories and clicks on add product option */
	@GetMapping(value = "editProduct/{productId}")
	public ModelAndView editProduct(@PathVariable Long productId, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView(PageName.LOGIN);

		User user = (User) session.getAttribute(KeyName.LOGIN_USER);

		if (user != null) {
			
			Set<Category> allCategories = categoryService.getAllCategories(user.getUserId());

			Product product = productService.findProduct(productId);
			
			modelAndView.setViewName(PageName.EDIT_PRODUCT);
			
			modelAndView.addObject(KeyName.SELECTED_PRODUCT, product);
			modelAndView.addObject(KeyName.ALL_CATEGORIES, allCategories);


		}

		return modelAndView;
	}

}
