package com.justjava.service;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justjava.model.Category;
import com.justjava.model.Product;
import com.justjava.repository.CategoryRepository;
import com.justjava.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public void addProduct(Product product) {
		productRepository.save(product);

	}

	public Set<Product> getAllProducts(Long creatorId) {

		Set<Product> products = new TreeSet<>();

		for (Product product : productRepository.findAllByCreatorId(creatorId)) {
			products.add(product);
		}

		return products;
	}

	public Set<Product> getAllProductsByCategory(Long creatorId, Long categoryId) {

		Set<Product> products = new TreeSet<>();

		Category category = categoryRepository.findOne(categoryId);

		for (Product Category : productRepository.findAllByCreatorIdAndCategory(creatorId, category)) {
			products.add(Category);
		}

		return products;
	}

	public Product findProduct(Long productId) {
		return productRepository.findOne(productId);

	}

}
