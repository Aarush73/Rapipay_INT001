package com.example.demo.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String email  ,  String message , String heading) 
	 {
       SimpleMailMessage msg = new SimpleMailMessage();
       message = message + generateOtp();
       msg.setTo(email);
       msg.setSubject(heading);
       msg.setText(message);
       javaMailSender.send(msg);
   }
	
	public String generateOtp()
	{
	   Random rnd = new Random();
	   int number = rnd.nextInt(999999);

	   return String.format("%06d", number);
	}

}
