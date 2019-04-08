package com.example.poc.dto;

import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
public class WeeklyNewsletterEmailRequest extends EmailRequestBase  {
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String newsletterDate;
	@NotNull
	private String newsletter;

	public WeeklyNewsletterEmailRequest() {
	}

	public WeeklyNewsletterEmailRequest(String firstName, String lastName, String newsletterDate, String newsletter) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.newsletterDate = newsletterDate;
		this.newsletter = newsletter;
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

	public String getNewsletterDate() {
		return newsletterDate;
	}

	public void setNewsletterDate(String newsletterDate) {
		this.newsletterDate = newsletterDate;
	}

	public String getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(String newsletter) {
		this.newsletter = newsletter;
	}

	@Override
	public String toString() {
		return "WeeklyNewsletterEmailRequest [firstName=" + firstName + ", lastName=" + lastName + ", newsletterDate="
				+ newsletterDate + ", newsletter=" + newsletter + "]";
	}

}
