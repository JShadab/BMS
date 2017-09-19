package com.justjava.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.justjava.utils.PageName;

@Controller
public class HomeController {

	@GetMapping(value = { "/", "/login" })
	String getLoginPage() {

		return PageName.LOGIN;
	}

	@GetMapping(value = "/dashboard.html")
	String getDashboard() {

		return PageName.DASHBORAD;
	}

	@GetMapping(value = "/addPurchase.html")
	String addPurchase() {

		return PageName.ADD_PURCHASE;
	}

	@GetMapping(value = "/addCustomer.html")
	String addCustomer() {

		return PageName.ADD_CUSTOMER;
	}



	// @GetMapping(value = "/updateCustomerDetails.html")
	// String updateCustomerDetails() {
	//
	// return "updateCustomerDetails";
	// }

	@GetMapping(value = "/register")
	String getRegistrationPage() {

		return PageName.REGISTRATION;
	}

	@GetMapping(value = "/error")
	String getErrorPage() {

		return "404";
	}

	@GetMapping(value = "/logout")
	String doLogOut(HttpSession session) {

		if (session != null) {
			session.invalidate();
		}

		return PageName.LOGIN;
	}

}
