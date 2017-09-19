package com.justjava.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.justjava.model.Customer;
import com.justjava.service.CustomerService;
import com.justjava.utils.PageName;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/updateCustomer.html")
	String updateCustomer() {

		return PageName.EDIT_DELETE_CUSTOMER;
	}

	@PostMapping(value = "/addCustomer")
	String addCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.addCustomer(customer);

		return "login";
	}

	@GetMapping(value = "/customer")
	@ResponseBody
	public Set<Customer> getAllCustomers() {

		return customerService.getAllCustomers();
	}

	@GetMapping(value = "/updateCustomer/{id}")
	public String updateCustomer(@PathVariable long id, Model model) {

		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customer", customer);

		return "updateCustomerDetails";

	}

	@PostMapping(value = "/updateCustomer")
	public String updateCustomerIntoDB(@ModelAttribute("customer") Customer customer, Model model) {

		customerService.addCustomer(customer);

		model.addAttribute("message", "Customer data updated Successfully");

		return "dashboard";

	}

	@DeleteMapping(value = "/customer/{id}")
	@ResponseBody
	public Set<Customer> deleteCustomer(@PathVariable long id) {

		customerService.deleteCustomer(id);

		return customerService.getAllCustomers();

	}
}
