package com.wipro.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bank.entity.Account;
import com.wipro.bank.entity.Customer;
import com.wipro.bank.model.FundTransfer;
import com.wipro.bank.service.AccountService;
import com.wipro.bank.service.CustomerService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/fetchAllAccounts")
	public List<Account> fetchAllAccounts() {
		return accountService.getAllAccounts();

	}

	@GetMapping("/fetchAllCustomers")
	public List<Customer> fetchAllCustomers() {
		return customerService.getAllCustomers();

	}
	
	@GetMapping("/intializeAccounts")
	public List<Account> intializeAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		Account acc1 = new Account(1, new Customer(1, "cust1"), 100.0);
		Account acc2 = new Account(2, new Customer(2, "cust2"), 0.0);
		Account acc4 = new Account(4, new Customer(4, "cust4"), 123.0);
		Account acc5 = new Account(5, new Customer(5, "cust5"), 984.0);
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc4);
		accounts.add(acc5);
		List<Account> accountList = accountService.addAllAccount(accounts);
		return accountList;

	}
	
	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public Account addAccount(@RequestBody Account newAccount) {
		return accountService.addAccount(newAccount);
	}
	
	@GetMapping("/getAccountBalance/{acNumber}")
	public Account getAccountBalance(@PathVariable int acNumber) {
		return accountService.getBalanceOf(acNumber);
	}
	
	@RequestMapping(value = "/transferFunds", method = RequestMethod.POST)
	public String transferFunds(@RequestBody FundTransfer fundTransfer) {
		return accountService.transferFunds(fundTransfer.getFromAccount(), fundTransfer.getToAccount(), fundTransfer.getAmount());
	}
}
