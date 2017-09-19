package com.justjava.repository;

import org.springframework.data.repository.CrudRepository;

import com.justjava.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);

}
