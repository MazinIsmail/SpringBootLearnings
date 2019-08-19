package com.wipro.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bank.entity.Account;
import com.wipro.bank.entity.Customer;
import com.wipro.bank.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public String addAccount(Account ac) {
		return "";
	}

	public List<Account> addAllAccount(List<Account> accountList) {
		List<Account> accountSuccess = accountRepository.saveAll(accountList);
		return accountSuccess;
	}

	public List<Account> getAllAccounts() {
		List<Account> accountList = accountRepository.findAll();
		return accountList;

	}

	public List<Customer> getAllCustomers() {
		return null;

	}

	public String transferFunds(int from, int to, double amount) {
		return null;

	}

	public Account getBalanceOf(int accountNumber) {
		return null;

	}

}
