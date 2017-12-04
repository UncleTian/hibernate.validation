package com.lin.luo.tian.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lin.luo.tian.annotation.AuthorizedBrand;
import com.lin.luo.tian.types.BrandTypes;

public class Car {
	@NotNull
	@Size(min = 2, max = 20)
	private String name;
	@Email
	private String email;
	@AuthorizedBrand(type=BrandTypes.DOMESTIC)
	private String brand;

	public Car(String name, String email, String brand) {
		this.name = name;
		this.email = email;
		this.brand = brand;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
