package com.example.poc.service.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.poc.dto.WelcomeEmailRequest;

@Service
public class WelcomeEmailListenerService {
	@Autowired
	private JavaMailSender emailSender;

	@RabbitListener(bindings = @QueueBinding(
		    value = @Queue(value = "welcome-queue", durable = "true"),
		    exchange = @Exchange(value = "email", ignoreDeclarationExceptions = "true"),
		    key = "WELCOME"))
	public void listenMessage(WelcomeEmailRequest emailRequest) {
		System.err.println(emailRequest);
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(emailRequest.getEmail()); 
        message.setSubject("Hoşgeldiniz!"); 
        message.setText("Sayın "+emailRequest.getFirstName()+", "+emailRequest.getLastName() +", aramıza hoşgeldiniz.");
        emailSender.send(message);		
	}
}
