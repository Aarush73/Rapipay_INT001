package com.rapipay.ACT.mini_project.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;
	private String clientName;
	private String clientPassword;
	private String clientState;
	private double walletBalance;
	private long phoneNumber;
	
	public Client(String clientName, String clientState, String clientPassword, double walletBalance, long phoneNumber) {
		this.clientName = clientName;
		this.clientState = clientState;
		this.clientPassword = clientPassword;
		this.walletBalance = walletBalance;
		this.phoneNumber = phoneNumber;
	}
}
