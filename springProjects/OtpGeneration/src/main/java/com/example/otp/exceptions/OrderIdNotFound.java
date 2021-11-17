package com.example.otp.exceptions;

public class OrderIdNotFound extends Throwable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "OrderIdNotFound Exception is thrown because entered orderId doesn't exist in database.";
	}
}
