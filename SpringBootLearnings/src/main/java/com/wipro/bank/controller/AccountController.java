package com.wipro.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bank.entity.Account;
import com.wipro.bank.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/fetchAllAccounts")
	public List<Account> fetchAllAccounts() {
		return accountService.getAllAccounts();

	}
}
