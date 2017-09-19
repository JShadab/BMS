package com.justjava.repository;

import org.springframework.data.repository.CrudRepository;

import com.justjava.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Iterable<Category> findAllByCreatorId(long creatorId);

}
