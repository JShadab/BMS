package com.justjava.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manufacturer implements Comparable<Manufacturer> {

	@Id
	@Column(name = "manufacturerId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long manufacturerId;

	private String name;
	private Long creatorId;


	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	@Override
	public int compareTo(Manufacturer category) {

		return this.name.compareTo(category.getName());
	}

	@Override
	public String toString() {
		return "Manufacturer [manufacturerId=" + manufacturerId + ", name=" + name + ", creatorId=" + creatorId + "]";
	}

}
