package com.example.otp.sendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailImpl implements SendEmail {

	@Autowired
	private JavaMailSender emailSender;

	@Override
	public void sendEmail(String to, int otp, int userId, int orderId) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(otp+"");
		msg.setText("Your OTP for userId : "+userId+" and orderId : "+orderId+" is : "+otp+". This OTP will expire in 2 minutes.");
		emailSender.send(msg);
	}
}