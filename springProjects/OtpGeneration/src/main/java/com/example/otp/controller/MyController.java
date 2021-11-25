package com.example.otp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.otp.bean.OTP;
import com.example.otp.exceptions.ExceededAttemptsException;
import com.example.otp.exceptions.InvalidEmailException;
import com.example.otp.exceptions.NegativeException;
import com.example.otp.services.OtpServices;

@RestController
public class MyController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);
	Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	private OtpServices otps;
	
	@PostMapping("/getOtp")
	public Object getOtp(@RequestBody OTP objectOTP) {
		try {
			LOGGER.info("for informational purpose");
			return otps.getOtp(objectOTP);
		} catch (NegativeException e) { 
			return e.toString();
		} catch (InvalidEmailException e1) {
			return e1.toString();
		} catch (Exception e2) {
			return e2.toString();
		} 
	}

	
	@GetMapping("/validateOtp/{userId}/{orderId}/{channelName}/{otp}")
	public Object validateOtp(@PathVariable int userId, @PathVariable int orderId, @PathVariable String channelName, @PathVariable int otp) {
		try {
			LOGGER.info("for informational purpose");
			return otps.validateOtp(userId, orderId, channelName, otp);
		} catch (NegativeException e) {
			return e.toString();
		} catch (ExceededAttemptsException e1) {
			return e1.toString();
		} catch (Exception e2) {
			return e2.toString();
		}
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
