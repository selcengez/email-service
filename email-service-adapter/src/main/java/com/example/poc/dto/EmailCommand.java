package com.example.poc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
public class EmailCommand implements Serializable {
	@NotNull
	private EmailServiceRequestType serviceType;
	private String receivedAt;
	@NotNull
	private EmailRequestBase requestData;

	public EmailCommand() {
	}

	public EmailServiceRequestType getServiceType() {
		return serviceType;
	}

	public void setServiceType(EmailServiceRequestType serviceType) {
		this.serviceType = serviceType;
	}

	public String getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}

	public EmailRequestBase getRequestData() {
		return requestData;
	}

	public void setRequestData(EmailRequestBase requestData) {
		this.requestData = requestData;
	}

	@Override
	public String toString() {
		return "EmailCommand [serviceType=" + serviceType + ", receivedAt=" + receivedAt + ", requestData="
				+ requestData + "]";
	}

}
