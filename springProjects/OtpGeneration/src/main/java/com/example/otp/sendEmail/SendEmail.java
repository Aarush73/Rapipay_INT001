package com.example.otp.sendEmail;

public interface SendEmail {
	public void sendEmail(String to, int otp, int userId, int orderId);
}
