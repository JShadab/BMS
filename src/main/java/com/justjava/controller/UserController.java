package com.justjava.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.justjava.model.User;
import com.justjava.service.UserService;
import com.justjava.utils.KeyName;
import com.justjava.utils.PageName;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/login")
	String doAuthenticate(@RequestParam String email, @RequestParam String password, HttpSession session) {

		User user = userService.getUser(email, password);

		if (user != null) {
			session.setAttribute(KeyName.LOGIN_USER, user);
			return "redirect:dashboard.html";
		}

		return PageName.LOGIN;
	}

	@PostMapping(value = "/register")
	String registerUser(@ModelAttribute("user") User user) {

		userService.addUser(user);

		return PageName.LOGIN;
	}
}
