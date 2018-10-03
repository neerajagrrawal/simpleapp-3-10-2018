package com.capgemini.simpleapp.repository;

import com.capgemini.simpleapp.entities.Customer;
import com.capgemini.simpleapp.exception.AccountNotFoundException;

public interface CustomerRepository {
	
	public Customer authenticate(Customer customer);

	public Customer updateProfile(Customer customer);

	public boolean updatePassword(Customer customer, String newPassword, String oldPassword);

}