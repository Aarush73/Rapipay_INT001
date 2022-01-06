package com.rapipay.transaction.services;

import java.util.List;

import com.rapipay.transaction.bean.Transaction;

public interface TransactionService {
	public Transaction getTransaction(int id);

	public List<Transaction> getAllTransaction();

	public String insertTransactionGeneration(Transaction tx);
	
	public String insertTransactionValiation(Transaction tx, int otp);

	public Object updateTransaction(Transaction tx, int id);

	public String deleteTransaction(int id);

	public List<Transaction> getTxByAgentId(int id);

	List<Transaction> getTxByClientId(int id);
}
