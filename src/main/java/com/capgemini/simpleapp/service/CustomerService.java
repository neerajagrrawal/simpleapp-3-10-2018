package com.capgemini.simpleapp.service;

import org.springframework.dao.EmptyResultDataAccessException;

import com.capgemini.simpleapp.entities.Customer;
import com.capgemini.simpleapp.exception.AccountNotFoundException;
import com.capgemini.simpleapp.exception.WrongCredentialsException;

public interface CustomerService {
	public Customer authenticate(Customer customer) throws EmptyResultDataAccessException, WrongCredentialsException;
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer,String newPassword,String oldPassword);

}