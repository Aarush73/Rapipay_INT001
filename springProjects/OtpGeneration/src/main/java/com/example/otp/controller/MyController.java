package com.example.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.otp.exceptions.ExceededAttemptsException;
import com.example.otp.exceptions.NegativeException;
import com.example.otp.services.OtpServices;

@RestController
public class MyController {
	
	@Autowired
	OtpServices otps;
	
	@GetMapping("/getOtp/{userId}/{orderId}/{channelName}")
	public Object getOtp(@PathVariable int userId, @PathVariable int orderId, @PathVariable String channelName) {
		try {
			return otps.getOtp(userId, orderId, channelName);
		} catch (NegativeException e) {
			return e.toString();
		} catch (Exception e1) {
			return e1.toString();
		}
	}

	
	@GetMapping("/validateOtp/{userId}/{orderId}/{channelName}/{otp}")
	public Object validateOtp(@PathVariable int userId, @PathVariable int orderId, @PathVariable String channelName, @PathVariable int otp) {
		try {
			return otps.validateOtp(userId, orderId, channelName, otp);
		} catch (NegativeException e) {
			return e.toString();
		} catch (ExceededAttemptsException e1) {
			return e1.toString();
		} catch (Exception e2) {
			return e2.toString();
		}
	}
}
