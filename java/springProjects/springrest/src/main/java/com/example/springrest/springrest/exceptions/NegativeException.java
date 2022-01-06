package com.example.springrest.springrest.exceptions;

public class NegativeException extends Exception {

	private static final long serialVersionUID = 1L;
	String message;

	public NegativeException() {
		this.message = "you entered one or more values less than 0 which is not possible";
	}

	@Override
	public String toString() {
		return "Negative Exception occured beacuse " + message;
	}
}
