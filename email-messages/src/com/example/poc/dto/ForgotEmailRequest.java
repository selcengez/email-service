package com.example.poc.dto;

import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
public class ForgotEmailRequest extends EmailRequestBase {
	@NotNull
	private String passwordResetUrl;

	public ForgotEmailRequest() {
	}

	public String getPasswordResetUrl() {
		return passwordResetUrl;
	}

	public void setPasswordResetUrl(String passwordResetUrl) {
		this.passwordResetUrl = passwordResetUrl;
	}

	@Override
	public String toString() {
		return "ForgotEmailRequest [passwordResetUrl=" + passwordResetUrl + "]";
	}

}
