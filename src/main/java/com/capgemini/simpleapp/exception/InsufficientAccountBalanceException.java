package com.capgemini.simpleapp.exception;
public class InsufficientAccountBalanceException extends Exception {

	public InsufficientAccountBalanceException(String message)
	{
		super(message);
	}
	
}