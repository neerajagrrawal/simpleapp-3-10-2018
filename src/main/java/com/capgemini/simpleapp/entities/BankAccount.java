package com.capgemini.simpleapp.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.stereotype.Component;


public class BankAccount {

	public BankAccount() {
		super();
		
	}
@Positive(message = "AccountId cannot be negative")
@NotNull (message = "AccountId cannot be blank")
private long accountId ;

@NotBlank(message = "AccountType cannot be blank")
private String accountType ;

@NotNull (message = "Balance cannot be blank")
@Positive(message = "Balance cannot be negative")
private double balance ;
public BankAccount(long accountId, String accountType, long balance) {
	super();
	this.accountId = accountId;
	this.accountType = accountType;
	this.balance = balance;
}
public long getAccountId() {
	return accountId;
}
public void setAccountId(long accountId) {
	this.accountId = accountId;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
}