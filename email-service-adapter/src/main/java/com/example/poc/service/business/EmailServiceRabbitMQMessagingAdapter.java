package com.example.poc.service.business;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.poc.dto.EmailCommand;
import com.example.poc.service.EmailServiceMessagingAdapter;

@Service
public class EmailServiceRabbitMQMessagingAdapter implements EmailServiceMessagingAdapter {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Value("${exchange.name}")
	private String exchangeName;
	
	@Override
	public void sendMessage(EmailCommand request) {
		rabbitTemplate.convertAndSend(exchangeName, request.getServiceType().name(), request.getRequestData());
	}

}
