package com.vk.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendMail(Mail mail) throws MailException{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setFrom(mail.getFrom());
		mailMessage.setTo(mail.getTo());
		mailMessage.setSubject(mail.getSubject());
		mailMessage.setText(mail.getBody());
		
		javaMailSender.send(mailMessage);
	}
}
