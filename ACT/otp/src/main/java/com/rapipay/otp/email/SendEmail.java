package com.rapipay.otp.email;

public interface SendEmail {
	public void sendEmail(String to, int otp, int agentId, int clientId);
}
