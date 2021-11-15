package com.example.otp.services;

import com.example.otp.exceptions.ExceededAttemptsException;
import com.example.otp.exceptions.NegativeException;

public interface OtpServices {
	public int getOtp(int userId, int orderId, String channelName) throws NegativeException;
	
	public String validateOtp(int userId, int orderId,String channelName, int otp) throws NegativeException, ExceededAttemptsException;
}
