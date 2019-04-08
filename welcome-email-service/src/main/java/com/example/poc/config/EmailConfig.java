package com.example.poc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
	@Value("${mail.transport.protocol}")
	private String mailTransportProtocol;
	@Value("${mail.smtp.auth}")
	private String mailSmtpAuth;
	@Value("${mail.smtp.starttls.enable}")
	private String mailSmtpStarttlsEnable;
	@Value("${mail.server.host}")
	private String mailServerHost;
	@Value("${mail.server.port}")
	private int mailServerPort;
	@Value("${mail.debug}")
	private String mailDebug;
	@Value("${mail.username}")
	private String mailUserName;
	@Value("${mail.password}")
	private String mailPassword;

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(mailServerHost);
		mailSender.setPort(mailServerPort);

		mailSender.setUsername(mailUserName);
		mailSender.setPassword(mailPassword);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", mailTransportProtocol);
		props.put("mail.smtp.auth", mailSmtpAuth);
		props.put("mail.smtp.starttls.enable", mailSmtpStarttlsEnable);
		props.put("mail.debug", mailDebug);

		return mailSender;
	}
}
