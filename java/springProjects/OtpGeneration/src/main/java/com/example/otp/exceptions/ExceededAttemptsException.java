package com.example.otp.exceptions;

public class ExceededAttemptsException extends Throwable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "ExceededAttemptsException occured because you failed to enter correct data within 5 attempts";
	}
}
