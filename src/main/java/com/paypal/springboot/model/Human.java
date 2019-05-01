package com.paypal.springboot.model;

import org.springframework.hateoas.ResourceSupport;

public class Human extends ResourceSupport{

	String firstName;
	String lastName;
	int number;
	
	public Human() {
		
	}
	
	public Human(String firstName, String lastName, int number) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
