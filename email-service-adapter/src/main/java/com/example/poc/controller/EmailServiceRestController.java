package com.example.poc.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.poc.dto.EmailCommand;
import com.example.poc.service.EmailServiceMessagingAdapter;

@RestController
@RequestScope
@RequestMapping("/email")
@Validated
@CrossOrigin
public class EmailServiceRestController {
	private EmailServiceMessagingAdapter messagingAdapter;

	public EmailServiceRestController(EmailServiceMessagingAdapter messagingAdapter) {
		this.messagingAdapter = messagingAdapter;
	}

	/*
	welcome request:  
	{
		  "receivedAt": "2019-04-07T11:04:51.859Z",
		  "requestData": { 
		           "type": "welcome",
		           "email": "selcen.tokluoglu@gmail.com",
		           "firstName": "selcen",
		           "lastName": "tokluoğlu"   
		      },
		  "serviceType": "WELCOME"
	}
	forgotPassword request
	{
		  "receivedAt": "2019-04-07T11:04:51.859Z",
		  "requestData": { 
		           "type": "forgot_email",
		           "email": "selcen.tokluoglu@gmail.com",
		           "passwordResetUrl": "passwordResetUrl"  
		      },
		  "serviceType": "FORGOT_PASSWORD"
	}
	newsletter request:  
	{
		  "receivedAt": "2019-04-07T11:04:51.859Z",
		  "requestData": { 
		           "type": "weekly_newsletter",
		           "email": "selcen.tokluoglu@gmail.com",
		           "firstName": "selcen",
		           "lastName": "tokluoğlu",
		           "newsletter":"Erken Rezervasyon Fırsatları"   
		      },
		  "serviceType": "WEEKLY_NEWSLATTER"
	}
	 */
	@PostMapping
	public void sendEmail(@RequestBody @Validated EmailCommand request) {
		this.messagingAdapter.sendMessage(request);
	}
}
