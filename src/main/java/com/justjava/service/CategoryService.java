package com.justjava.service;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justjava.model.Category;
import com.justjava.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void addCategotegory(Category category) {
		categoryRepository.save(category);

	}

	public Set<Category> getAllCategories(Long creatorId) {

		Set<Category> categories = new TreeSet<>();

		categoryRepository.findAllByCreatorId(creatorId);

		Iterable<Category> allCategories = categoryRepository.findAll();

		for (Category Category : allCategories) {
			categories.add(Category);
		}

		return categories;
	}

}
