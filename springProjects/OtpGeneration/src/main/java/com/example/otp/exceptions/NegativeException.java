package com.example.otp.exceptions;

public class NegativeException extends Throwable{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "NegativeException Occured because you entered one or more values less than zero";
	}

}
