package com.example.poc.dto;

import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
public class WelcomeEmailRequest extends EmailRequestBase {
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;

	public WelcomeEmailRequest() {
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

	@Override
	public String toString() {
		return "WelcomeEmailRequest [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
