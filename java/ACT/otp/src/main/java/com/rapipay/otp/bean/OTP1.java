package com.rapipay.otp.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OTP1 {
	
	private int agentId;
//	@Id
	private int clientId;
	private int otp;
	@Id
	private int s_no;
	
	public OTP1(int agentId, int clientId) {
		this.agentId = agentId;
		this.clientId = clientId;
	}
}
