package com.capgemini.simpleapp.repository.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capgemini.simpleapp.entities.BankAccount;
import com.capgemini.simpleapp.entities.Customer;
import com.capgemini.simpleapp.exception.AccountNotFoundException;
import com.capgemini.simpleapp.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Customer authenticate(Customer customer) throws EmptyResultDataAccessException {
		try {
			return jdbcTemplate.queryForObject(
					"select * from customer join bankAccount on customer.account_Id=bankAccount.account_Id WHERE customer.customer_id = ? AND customer.password = ?",
					new Object[] { customer.getCustomerId(), customer.getPassword() }, new CustomerRowMapper());
		} catch (EmptyResultDataAccessException e) {
			e.initCause(new EmptyResultDataAccessException("Incorrect result size: expected 1, actual 0", 1)) ;
			throw e ;
		}

	}

	@Override
	public Customer updateProfile(Customer customer) {
		jdbcTemplate.update("UPDATE customer set customer_name=?,email=?,location=?,dob=? where customer_id=?",
				new Object[] { customer.getCustomerName(), customer.getEmail(), customer.getAddress(),
						Date.valueOf(customer.getDateOfBirth()), (int) customer.getCustomerId() });

		Customer newCustomer = jdbcTemplate.queryForObject("select * from customer WHERE customer_id = ?",
				new Object[] { customer.getCustomerId() }, new CustomerRowMapper());

		return newCustomer;
	}

	@Override
	public boolean updatePassword(Customer customer, String newPassword, String oldPassword) {

		int count = jdbcTemplate.update("UPDATE customer set password=? where customer_id=? and password=?",
				new Object[] { newPassword, customer.getCustomerId(), oldPassword });
		return count != 0;

	}

	private class CustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt(1));
			customer.setCustomerName(rs.getString(2));
			customer.setPassword(rs.getString(3));
			customer.setEmail(rs.getString(4));
			customer.setAddress(rs.getString(5));
			customer.setDateOfBirth(rs.getDate(6).toLocalDate());

			BankAccount account = jdbcTemplate.queryForObject("select * from bankAccount WHERE customer_id = ?",
					new Object[] { rs.getInt(1) }, new BankAccountRowMapper());

			customer.setAccount(account);
			return customer;

		}

	}

	private class BankAccountRowMapper implements RowMapper<BankAccount> {

		@Override
		public BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
			BankAccount bankAccount = new BankAccount();
			bankAccount.setAccountId(rs.getInt(1));
			bankAccount.setAccountType(rs.getString(2));
			bankAccount.setBalance(rs.getDouble(3));
			return bankAccount;
		}

	}

}
