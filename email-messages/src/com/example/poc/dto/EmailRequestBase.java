package com.example.poc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@SuppressWarnings("serial")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = WelcomeEmailRequest.class, name = "welcome"),
		@Type(value = ForgotEmailRequest.class, name = "forgot_email"),
		@Type(value = WeeklyNewsletterEmailRequest.class, name = "weekly_newsletter") })
public abstract class EmailRequestBase implements Serializable {
	private String email;

	public EmailRequestBase() {
	}

	public EmailRequestBase(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
