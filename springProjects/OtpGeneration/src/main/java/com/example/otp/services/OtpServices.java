package com.example.otp.services;

import com.example.otp.bean.OTP;
import com.example.otp.exceptions.ExceededAttemptsException;
import com.example.otp.exceptions.InvalidEmailException;
import com.example.otp.exceptions.NegativeException;

public interface OtpServices {
	public int getOtp(OTP objectOTP) throws NegativeException, InvalidEmailException;
	
	public String validateOtp(int userId, int orderId,String channelName, int otp) throws NegativeException, ExceededAttemptsException;
}
