package com.justjava.service;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justjava.model.Manufacturer;
import com.justjava.repository.ManufacturerRepository;

@Service
public class ManufacturerService {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	public void addManufacture(Manufacturer manufacturer) {
		manufacturerRepository.save(manufacturer);

	}

	public Set<Manufacturer> getAllManufacturers(long creatorId) {

		Set<Manufacturer> manufacturers = new TreeSet<>();

		for (Manufacturer manufacturer : manufacturerRepository.findAllByCreatorId(creatorId)) {
			manufacturers.add(manufacturer);
		}

		return manufacturers;
	}

}
