package com.capgemini.simpleapp.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.simpleapp.exception.AccountNotFoundException;
import com.capgemini.simpleapp.exception.InsufficientAccountBalanceException;
import com.capgemini.simpleapp.exception.NegativeAmountException;
import com.capgemini.simpleapp.exception.WrongCredentialsException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	protected String handleConflict(Exception ex,WebRequest request) {
		System.out.println("Hhandler");
		request.setAttribute("exception", ex, 0);
		return "errorMessages";
	}

}
