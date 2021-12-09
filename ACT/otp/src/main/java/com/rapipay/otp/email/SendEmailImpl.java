package com.rapipay.otp.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailImpl implements SendEmail {

	@Autowired
	private JavaMailSender emailSender;

	@Override
	public void sendEmail(String to, int otp, int agentId, int clientId) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(otp+"");
		msg.setText("Your OTP to Fund Transfer for agentId : "+agentId+" and clientId : "+clientId+" is : "+otp+". This OTP will expire in 2 minutes.");
		emailSender.send(msg);
	}
}
