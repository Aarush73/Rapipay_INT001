package com.rapipay.ACT.mini_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rapipay.ACT.mini_project.bean.Transaction;
import com.rapipay.ACT.mini_project.services.ACTService;

@CrossOrigin
@RestController
public class TransactionController {

	@Autowired
	ACTService service;
	
	@GetMapping("/transaction/{id}")
	public Transaction getTransaction(@PathVariable int id) {
		return service.getTransaction(id);
	}
	
	@GetMapping("/transaction/all")
	public List<Transaction> getAllTransaction() {
		return service.getAllTransaction();
	}
	
	@PostMapping("/transaction/insert")
	public Transaction insertTransaction(@RequestBody Transaction transaction) {
		return service.insertTransaction(transaction);
	}
	
	@PutMapping("/transaction/update/{id}")
	public Object updateTransaction(@RequestBody Transaction tx, @PathVariable int id) {
		return service.updateTransaction(tx, id);
	}
	
	@DeleteMapping("/transaction/delete/{id}")
	public String deleteTransaction(@PathVariable int id) {
		return service.deleteTransaction(id);
	}
}
