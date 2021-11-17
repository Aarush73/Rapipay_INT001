package com.example.otp.exceptions;

public class InvalidEmailException extends Throwable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "InvalidEmailException occured because email entered is invalid";
	}

}
