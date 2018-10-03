package com.capgemini.simpleapp.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.simpleapp.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double getBalance(long accountId) throws DataAccessException {
		try {
			System.out.println("repo try of "+accountId);
			return jdbcTemplate.queryForObject("select balance from bankAccount where account_Id=?",
					new Object[] { accountId }, Double.class);
		} catch (DataAccessException e) {
			System.out.println("repo catch of "+accountId);
			e.initCause(new EmptyResultDataAccessException("Incorrect result size: expected 1, actual 0", 1));
			throw e;
		}

	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) throws DataAccessException {
		try {
			int count = jdbcTemplate.update("UPDATE bankAccount set balance=? where account_Id=?",
					new Object[] { newBalance, (int) accountId });
			return count != 0;
		} catch (DataAccessException e) {
			e.initCause(new EmptyResultDataAccessException("Incorrect result size: expected 1, actual 0", 1));
			throw e;
		}
	}

}
