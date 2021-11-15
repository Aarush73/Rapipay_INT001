package com.example.otp.sendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmailImpl implements SendEmail{
	
	@Autowired
	private JavaMailSender emailSender;
	
	public void sendEmail(String to, int otp, int userId, int orderId) {
//		System.out.println(emailSender.toString());
//		System.out.println("hi");
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setFrom("aarushgandhi2007@gmail.com");
		msg.setSubject("Hey User your OTP is : ");
		msg.setText(otp+" for userID : "+userId+" and orderId : "+orderId);
		emailSender.send(msg);
	}
}