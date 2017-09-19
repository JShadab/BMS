package com.justjava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Product implements Comparable<Product> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;

	@OneToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	@OneToOne
	@JoinColumn(name = "manufacturerId")
	private Manufacturer manufacturer;

	private String name;
	private String barcode;
	private int quantity;
	private float purchaseRate;
	private float sellingRate;

	private Long creatorId;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(float purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public float getSellingRate() {
		return sellingRate;
	}

	public void setSellingRate(float sellingRate) {
		this.sellingRate = sellingRate;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Product product) {
		return this.getName().compareTo(product.getName());
	}

}
