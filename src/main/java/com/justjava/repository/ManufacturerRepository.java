package com.justjava.repository;

import org.springframework.data.repository.CrudRepository;

import com.justjava.model.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {

	Iterable<Manufacturer> findAllByCreatorId(long creatorId);

	

}
