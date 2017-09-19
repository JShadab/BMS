package com.justjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justjava.model.User;
import com.justjava.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUser(String email, String password) {

		User user = userRepository.findByEmailAndPassword(email, password);

		return user;

	}

	public User addUser(User user) {
		return userRepository.save(user);

	}

}
