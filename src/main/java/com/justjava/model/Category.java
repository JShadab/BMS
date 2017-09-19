package com.justjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category implements Comparable<Category> {

	@Id
	@Column(name = "categoryId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;

	private String name;
	private Long creatorId;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	@Override
	public int compareTo(Category category) {

		return this.name.compareTo(category.getName());
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", creatorId=" + creatorId + "]";
	}

}
