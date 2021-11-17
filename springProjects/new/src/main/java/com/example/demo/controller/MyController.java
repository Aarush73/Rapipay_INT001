package com.example.demo.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class MyController {
	
	@Autowired
	private MyService myservice;
  //private JavaMailSender javaMailSender;
  
  @CrossOrigin
	@PostMapping("/home/{email}")
	public String home(@PathVariable String email) 
	
	 {
      myservice.sendEmail(email, "OTP: " , "OTP"); // pass email id  , message , heading  
			return "email sent";
	 }
 
  
	//void sendEmail(String email  ,  String message , String heading) 
	 //{
        //SimpleMailMessage msg = new SimpleMailMessage();
        //msg.setTo(email);
        //msg.setSubject(heading);
        //msg.setText(message);
        //javaMailSender.send(msg);
    //}
}
