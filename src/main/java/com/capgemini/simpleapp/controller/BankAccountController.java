package com.capgemini.simpleapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.simpleapp.entities.Customer;
import com.capgemini.simpleapp.exception.AccountNotFoundException;
import com.capgemini.simpleapp.exception.InsufficientAccountBalanceException;
import com.capgemini.simpleapp.exception.NegativeAmountException;
import com.capgemini.simpleapp.service.BankAccountService;

@Controller
public class BankAccountController {

	
	@Autowired
	private BankAccountService bankServices;
	
	@RequestMapping(value = "/transferMoneyPage", method = RequestMethod.GET)
	public String getTransferMoneyPage() {
		return "transferMoney";
	}
	
	@RequestMapping(value = "/transferMoney", method = RequestMethod.POST)
	public String getTransferMoney(Model model,HttpSession session,@RequestParam("toAccountId") long toAccount,@RequestParam("amount") double amount) throws InsufficientAccountBalanceException, AccountNotFoundException, NegativeAmountException {
//		try {
			Customer c=(Customer)session.getAttribute("customer") ;
			long fromAccountId=c.getAccount().getAccountId() ;
			if(bankServices.fundTransfer(fromAccountId, toAccount, amount))
			{
				Customer customer=(Customer) session.getAttribute("customer") ;
				customer.getAccount().setBalance(bankServices.getBalance(customer.getAccount().getAccountId()));
			}
			
//		}
		/*catch(Exception e){
			model.addAttribute("exception", e) ;
			return "errorMessages" ;
			 
		}*/
		
		return "dashboard" ;
	}
}
