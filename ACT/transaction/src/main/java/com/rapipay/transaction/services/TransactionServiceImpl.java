package com.rapipay.transaction.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapipay.transaction.bean.Transaction;
import com.rapipay.transaction.dao.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
    private TransactionDao txDao; 
	
	@Override
	public Transaction getTransaction(int id) {
		return txDao.findById(id).get();
	}

	@Override
	public Transaction insertTransaction(Transaction tx) {
		return txDao.saveAndFlush(tx);
	}

	@Override
	public Object updateTransaction(Transaction tx, int id) {
		if(txDao.existsById(id)) {
			Transaction oldTx = txDao.findById(id).get();
			
			oldTx.setAgentId(tx.getAgentId() != 0 ? tx.getAgentId() : oldTx.getAgentId());
			oldTx.setClientId(tx.getClientId() != 0 ? tx.getClientId() : oldTx.getClientId());
			oldTx.setAmount(tx.getAmount() != 0 ? tx.getAmount() : oldTx.getAmount());
			oldTx.setTType(tx.getTType() != null ? tx.getTType() : oldTx.getTType());
			oldTx.setTDate(tx.getTDate() != null ? tx.getTDate() : oldTx.getTDate());
		    return txDao.saveAndFlush(oldTx);
		}
		return "Transaction Not Found";
	}

	@Override
	public String deleteTransaction(int id) {
		txDao.deleteById(id);
		return "Transaction Deleted";
	}

	@Override
	public List<Transaction> getAllTransaction() {
		return txDao.findAll();
	}
	
	public List<Transaction> getTransactionsByAgentId(int id) {
		List<Transaction> list = new ArrayList<>();
		return list.stream().filter((tx)->tx.getAgentId() == id).collect(Collectors.toList());
	}
	
	public List<Transaction> getTransactionsByClientId(int id) {
		List<Transaction> list = new ArrayList<>();
		return list.stream().filter((c)->c.getClientId() == id).collect(Collectors.toList());
	}
}
