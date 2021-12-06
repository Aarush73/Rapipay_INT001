package com.rapipay.agent.bean;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int agentId;
	private String agentName;
	private String agentState;
	private String bankName;
	private long accountNumber;
	private long phoneNumber;
	private double walletBalance;
	
	private ArrayList<Client> listClients;
	
	private ArrayList<Transaction> listTx;
	
	public Agent(String agentName, String agentState, String bankName, long accountNumber, long phoneNumber, double walletBalance, ArrayList<Client> listClients, ArrayList<Transaction> listTx) {
		this.agentName = agentName;
		this.agentState = agentState;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.phoneNumber = phoneNumber;
		this.walletBalance = walletBalance;
		this.listClients = listClients;
		this.listTx = listTx;
	} 
}
