package com.rapipay.client.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
	private LocalDate tDate;
	private int agentId;
	private int clientId;
	private String tType;
	private int amount;
	
	public Transaction(LocalDate tDate, int agentId, int clientId, String type, int amount) {
		this.tDate = tDate;
		this.agentId = agentId; 
		this.clientId = clientId;
		this.tType = type;
		this.amount = amount;
	}
}
