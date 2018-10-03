package com.capgemini.simpleapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.simpleapp.exception.AccountNotFoundException;
import com.capgemini.simpleapp.exception.InsufficientAccountBalanceException;
import com.capgemini.simpleapp.exception.NegativeAmountException;
import com.capgemini.simpleapp.repository.impl.BankAccountRepositoryImpl;
import com.capgemini.simpleapp.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepositoryImpl bankRepository;

	@Override
	public double getBalance(long accountId) throws AccountNotFoundException {

		try {
			double amt = bankRepository.getBalance(accountId);
			return amt;
		} catch (DataAccessException e) {
			AccountNotFoundException accountNotFoundException = new AccountNotFoundException("Account Id not Found");
			accountNotFoundException.initCause(e);
			throw accountNotFoundException;
		}

	}

	@Override
	public double withdraw(long accountId, double amount)
			throws InsufficientAccountBalanceException, NegativeAmountException, AccountNotFoundException {
		double balance;

		balance = getBalance(accountId);
		if (balance < amount)
			throw new InsufficientAccountBalanceException("Your account balance is low!!");
		if (amount < 0)
			throw new NegativeAmountException("You have entered negative amount!!");

		bankRepository.updateBalance(accountId, balance - amount);
		return bankRepository.getBalance(accountId);
	}

	@Override
	public double deposit(long accountId, double amount) throws AccountNotFoundException {
		double balance = getBalance(accountId);
		System.out.println("should not exec");
		bankRepository.updateBalance(accountId, (balance + amount));
		return getBalance(accountId);
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount)
			throws InsufficientAccountBalanceException, AccountNotFoundException, NegativeAmountException {

		/*
		 * if(bankRepository.getBalance(toAcc)==-1) { throw new
		 * AccountNotFoundException("The Account Id is incorrect!!"); } if
		 * (bankRepository.getBalance(fromAcc) < amount) { throw new
		 * InsufficientAccountBalanceException("Your account balance is low!!"); }
		 * 
		 * if (amount < 0) { throw new
		 * NegativeAmountException("You have entered negative amount"); }
		 */

		withdraw(fromAcc, amount);
		deposit(toAcc, amount);
		return true;

	}

}