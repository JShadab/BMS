package com.justjava.service;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justjava.model.Customer;
import com.justjava.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);

	}

	public Set<Customer> getAllCustomers() {

		Set<Customer> customers = new TreeSet<>();

		for (Customer customer : customerRepository.findAll()) {
			customers.add(customer);
		}

		return customers;
	}

	public boolean deleteCustomer(long id) {

		boolean isExists = customerRepository.exists(id);

		if (isExists) {
			customerRepository.delete(id);
		}

		return isExists;

	}

	public Customer getCustomer(long id) {

		return customerRepository.findOne(id);
	}

}
