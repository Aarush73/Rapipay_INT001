package com.rapipay.otp.service;

public interface OTPService {
	public int generateOTP(int agentId, int clientId, String type);
	
	public boolean validateOTP(int agentId, int clientId, int otp);
}
