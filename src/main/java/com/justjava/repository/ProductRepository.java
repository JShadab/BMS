package com.justjava.repository;

import org.springframework.data.repository.CrudRepository;

import com.justjava.model.Category;
import com.justjava.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	Iterable<Product> findAllByCreatorId(long creatorId);

	Iterable<Product> findAllByCreatorIdAndCategory(Long creatorId, Category category);

}
