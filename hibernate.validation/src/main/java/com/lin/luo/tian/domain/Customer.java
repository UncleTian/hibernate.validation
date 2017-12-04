package com.lin.luo.tian.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	private static final String REGEX_EMAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
	private Integer id;
	@Pattern(regexp="^[a-zA-Z]+$", flags={Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.COMMENTS})
	private String name;
	@Email(regexp=REGEX_EMAIL)
	private String email;
	@Future
	private Date date;
	
	private List<String> goodsList = new ArrayList<>();

	public Customer(Integer id, @NotNull String name) {
		this.id = id;
		this.name = name;
	}

	public void printFutureDate(@FutureOrPresent Date futureDate) {
		System.out.println(futureDate);
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Size(min=1)
	public List<String> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<String> goodsList) {
		this.goodsList = goodsList;
	}

}
