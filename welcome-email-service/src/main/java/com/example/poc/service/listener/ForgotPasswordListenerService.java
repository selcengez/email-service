package com.example.poc.service.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.poc.dto.ForgotEmailRequest;

public class ForgotPasswordListenerService {
	@Autowired
	private JavaMailSender emailSender;

	@RabbitListener(queues = "forgot-password-queue")
	@RabbitListener(bindings = @QueueBinding(
		    value = @Queue(value = "forgot-password-queue", durable = "true"),
		    exchange = @Exchange(value = "email", ignoreDeclarationExceptions = "true"),
		    key = "FORGOT_PASSWORD"))
	public void listenMessage(ForgotEmailRequest emailRequest) {
		System.err.println(emailRequest);
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(emailRequest.getEmail()); 
        message.setSubject("Şifre yenileme"); 
        message.setText("Şifrenizi yenilemek için aşağıdaki linke tıklayınız"+ emailRequest);
        emailSender.send(message);		
	}
}
