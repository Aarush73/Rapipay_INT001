package com.rapipay.transaction.services;

import java.util.List;

import com.rapipay.transaction.bean.Transaction;

public interface TransactionService {
	public Transaction getTransaction(int id);

	public List<Transaction> getAllTransaction();

	public Transaction insertTransaction(Transaction tx);

	public Object updateTransaction(Transaction tx, int id);

	public String deleteTransaction(int id);
}
