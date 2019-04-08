package com.example.poc.service.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.poc.dto.WeeklyNewsletterEmailRequest;

@Service
public class NewsletterEmailListenerService {
	@Autowired
	private JavaMailSender emailSender;

	@RabbitListener(bindings = @QueueBinding(
		    value = @Queue(value = "newsletter-queue", durable = "true"),
		    exchange = @Exchange(value = "email", ignoreDeclarationExceptions = "true"),
		    key = "WEEKLY_NEWSLATTER"))
	public void listenMessage(WeeklyNewsletterEmailRequest emailRequest) {
		System.err.println(emailRequest);
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(emailRequest.getEmail()); 
        message.setSubject(emailRequest.getFirstName()+", "+ emailRequest.getNewsletterDate() +", tarihli bültenimizi kaçırma"); 
        message.setText("Merhaba " + emailRequest.getFirstName()+", "+ emailRequest.getLastName() +"; " + emailRequest.getNewsletter());
        emailSender.send(message);		
	}
}
