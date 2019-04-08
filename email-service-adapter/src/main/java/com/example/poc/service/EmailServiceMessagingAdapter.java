package com.example.poc.service;

import com.example.poc.dto.EmailCommand;

public interface EmailServiceMessagingAdapter {

	void sendMessage(EmailCommand request);

}
