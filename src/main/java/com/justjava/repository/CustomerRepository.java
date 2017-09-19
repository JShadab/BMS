package com.justjava.repository;

import org.springframework.data.repository.CrudRepository;

import com.justjava.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {



}
