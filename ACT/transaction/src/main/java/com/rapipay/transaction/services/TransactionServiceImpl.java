package com.rapipay.transaction.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rapipay.transaction.bean.Agent;
import com.rapipay.transaction.bean.Client;
import com.rapipay.transaction.bean.Transaction;
import com.rapipay.transaction.dao.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao txDao;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Transaction getTransaction(int id) {
		return txDao.findById(id).get();
	}

	@Override
	public String insertTransactionGeneration(Transaction tx) {
		restTemplate.getForObject("http://localhost:7073/otp/generate/"+tx.getAgentId()+"/"+tx.getClientId()+"/"+tx.getTType(), Integer.class);
		return "Fund Transfer Initiated, kindly enter the OTP sent to your email.";
	}
	
	@Override
	public String insertTransactionValiation(Transaction tx, int otp) {
		boolean valid = restTemplate.getForObject("http://localhost:7073/otp/validate/"+tx.getAgentId()+"/"+tx.getClientId()+"/"+otp, Boolean.class);
		System.out.println(valid);
		
		if (valid) {
			Agent a = restTemplate.getForObject("http://localhost:7075/agent/" + tx.getAgentId(), Agent.class);
			Client c = restTemplate.getForObject("http://localhost:7071/client/" + tx.getClientId(), Client.class);

			if (tx.getTType().equals("AtoC")) {
				if(tx.getAmount() > a.getWalletBalance()) {
					return "Insufficient Balance in Agent's Account!";
				}
				a.setWalletBalance(a.getWalletBalance() - tx.getAmount());
				c.setWalletBalance(c.getWalletBalance() + tx.getAmount());
			} else {
				if(tx.getAmount() > c.getWalletBalance()) {
					return "Insufficient Balance in Client's Account!";
				}
				a.setWalletBalance(a.getWalletBalance() + tx.getAmount());
				c.setWalletBalance(c.getWalletBalance() - tx.getAmount());
			}

			restTemplate.put("http://localhost:7075/agent/update/" + tx.getAgentId(), a);
			restTemplate.put("http://localhost:7071/client/update/" + tx.getClientId(), c);
			txDao.saveAndFlush(tx);
			return "Fund Transferred with Transaction-Id : "+tx.getTId();
		} else return "Wrong OTP entered";
	}

	@Override
	public Object updateTransaction(Transaction tx, int id) {
		if (txDao.existsById(id)) {
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

	@Override
	public List<Transaction> getTxByAgentId(int id) {
		List<Transaction> list = txDao.findAll();
		return list.stream().filter((tx) -> tx.getAgentId() == id).collect(Collectors.toList());
	}

	@Override
	public List<Transaction> getTxByClientId(int id) {
		List<Transaction> list = txDao.findAll();
		return list.stream().filter((c) -> c.getClientId() == id).collect(Collectors.toList());
	}
}
