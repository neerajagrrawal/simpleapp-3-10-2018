package com.capgemini.simpleapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.simpleapp.entities.Customer;
import com.capgemini.simpleapp.exception.AccountNotFoundException;
import com.capgemini.simpleapp.exception.WrongCredentialsException;
import com.capgemini.simpleapp.repository.impl.CustomerRepositoryImpl;
import com.capgemini.simpleapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepositoryImpl custRepObj;

	@Override
	public Customer authenticate(Customer customer)  throws WrongCredentialsException {
		try {
			return custRepObj.authenticate(customer);
		}
		catch (DataAccessException e) {
			WrongCredentialsException credentialsException=new WrongCredentialsException("Wrong Credentials!!") ;
			credentialsException.initCause(e) ;
			throw credentialsException ;
		}
		

	}

	@Override
	public Customer updateProfile(Customer customer) {
		return custRepObj.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String newPassword, String oldPassword) {
		return custRepObj.updatePassword(customer, newPassword, oldPassword);
	}

}