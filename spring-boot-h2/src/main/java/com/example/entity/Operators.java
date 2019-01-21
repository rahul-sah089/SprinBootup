package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Operators {
	@Id
	@Min(value = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "OPERATOR_NAME")
	private String name;
	@Column(name = "LOWEST_PRICE")
	private String lowestPrice;
	@Column(name = "RATING")
	private String rating;
	@Column(name = "MAX_SPEEED")
	private String maxSpeed;
	@Column(name = "DESCRIPTION")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(String lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String contactNo;
	private String email;
	private String image;
	private String url;

	public Operators() {

	}

	public Operators(String name, String lowestPrice, String rating, String maxSpeed, String description,
			String contactNo, String email, String image, String url) {
		super();
		this.name = name;
		this.lowestPrice = lowestPrice;
		this.rating = rating;
		this.maxSpeed = maxSpeed;
		this.description = description;
		this.contactNo = contactNo;
		this.email = email;
		this.image = image;
		this.url = url;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
