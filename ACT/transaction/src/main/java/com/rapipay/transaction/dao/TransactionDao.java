package com.rapipay.transaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapipay.transaction.bean.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {
	
}
