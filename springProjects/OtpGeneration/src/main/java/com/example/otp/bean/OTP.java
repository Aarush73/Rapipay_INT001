package com.example.otp.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OTP {
	
	private int userId;
	@Id
	private int orderId;
	private String channelName;
	private int otp;
	private int attempts;
	private String email;

	public OTP() {
		this.userId = 0;
		this.orderId = 0;
		this.channelName = "";
		this.otp = 0;
		this.attempts = 0;
		this.email = "";
	}
	
	public OTP(int userId, int orderId, String channel, String email) {
		this.userId = userId;
		this.orderId = orderId;
		this.channelName = channel;
		this.email = email;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "OTP [userId=" + userId + ", orderId=" + orderId + ", channelName=" + channelName + ", otp=" + otp
				+ ", attempts=" + attempts + ", email=" + email + "]";
	}
}
