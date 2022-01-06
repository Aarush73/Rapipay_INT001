package com.example.springrest.springrest.exceptions;

public class MaxAmountException extends Exception {
	private static final long serialVersionUID = 1L;
	
	String message;
	
	public MaxAmountException() {
		this.message = "you entered Prinicpal Amount more than 10000000 which is not possible";
	}

	@Override
	public String toString() {
		return "Max Amount Exception occured beacuse " + message;
	}
}
