package com.rapipay.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rapipay.transaction.bean.Transaction;
import com.rapipay.transaction.services.TransactionService;

//@CrossOrigin
@RestController
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@GetMapping("/transaction/{id}")
	public Transaction getTransaction(@PathVariable int id) {
		return service.getTransaction(id);
	}
	
	@GetMapping("/transaction/all")
	public List<Transaction> getAllTransaction() {
		return service.getAllTransaction();
	}
	
	@PostMapping("/transaction/insert-p1")
	public String insertTransactionGeneration(@RequestBody Transaction tx) {
		return service.insertTransactionGeneration(tx);
	}
	
	@PostMapping("/transaction/insert-p2/{otp}")
	public String insertTransactionValidation(@RequestBody Transaction transaction, @PathVariable int otp) {
		return service.insertTransactionValiation(transaction, otp);
	}
	
	@PutMapping("/transaction/update/{id}")
	public Object updateTransaction(@RequestBody Transaction tx, @PathVariable int id) {
		return service.updateTransaction(tx, id);
	}
	
	@DeleteMapping("/transaction/delete/{id}")
	public String deleteTransaction(@PathVariable int id) {
		return service.deleteTransaction(id);
	}
	
	@GetMapping("/transaction/agent/{id}")
	public List<Transaction> getTxByAgentId(@PathVariable int id) {
		return service.getTxByAgentId(id);
	}
	
	@GetMapping("/transaction/client/{id}")
	public List<Transaction> getTxByClientId(@PathVariable int id) {
		return service.getTxByClientId(id);
	}
}
