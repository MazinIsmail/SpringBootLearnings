package com.wipro.bank.service;

import java.util.List;

import com.wipro.bank.entity.Account;

public interface AccountService {

	public Account addOrUpdateAccount(Account account);

	public List<Account> addAllAccount(List<Account> accountList);

	public List<Account> getAllAccounts();

	public String transferFunds(int accountFromId, int accountToId, double transferAmount);

	public Account getBalanceOf(int accountNumber);
}
