package com.rapipay.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rapipay.otp.service.OTPService;

@RestController
@RequestMapping("/otp")
public class OTPController {
	
	@Autowired
	private OTPService service;
	
	@GetMapping("/generate/{agentId}/{clientId}/{tType}")
	public int generateOTP(@PathVariable int agentId, @PathVariable int clientId, @PathVariable String tType) {
		return service.generateOTP(agentId, clientId, tType);
	}
	
	@GetMapping("/validate/{agentId}/{clientId}/{otp}")
	public boolean validateOTP(@PathVariable int agentId, @PathVariable int clientId, @PathVariable int otp) {
		return service.validateOTP(agentId, clientId, otp);
	}
}
