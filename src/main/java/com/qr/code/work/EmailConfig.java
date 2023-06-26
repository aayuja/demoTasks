package com.qr.code.work;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailConfig
{
	@Bean
	public SimpleMailMessage emailTemplate()
	{
		SimpleMailMessage message = new SimpleMailMessage();
		mailto:message.setTo("user@gmail.com");
		mailto:message.setFrom("admin@gmail.com");
		message.setSubject("Important email");
	    message.setText("FATAL - Application crash. Save your job !!");
	    return message;
	}
}