package com.rapipay.ACT.mini_project.exceptions;

public class NotFoundException extends Throwable{

	private static final long serialVersionUID = 1L;
	private String message = "NotFoundException occured because it doesn't exist";
	
	public NotFoundException(String className) {
		message = className + "";
	}
	
	@Override
	public String toString() {
		return message;
	}
}
