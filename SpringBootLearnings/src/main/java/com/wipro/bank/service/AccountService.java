package com.wipro.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bank.entity.Account;
import com.wipro.bank.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public Account addOrUpdateAccount(Account account) {
		return accountRepository.save(account);
	}


	public List<Account> addAllAccount(List<Account> accountList) {
		List<Account> accountSuccess = accountRepository.saveAll(accountList);
		return accountSuccess;
	}

	public List<Account> getAllAccounts() {
		List<Account> accountList = accountRepository.findAll();
		return accountList;
	}

	public String transferFunds(int accountFromId, int accountToId, double transferAmount) {
		Account accountFrom = accountRepository.findByAccountId(accountFromId);
		if(accountFrom != null) {
			if(transferAmount > accountFrom.getBalance()) {
				return "INSUFFICIENT FUNDS";
			} else {
				Account accountTo = accountRepository.findByAccountId(accountToId);
				if(accountTo != null) {
					accountTo.setBalance(accountTo.getBalance() + transferAmount);
					accountFrom.setBalance(accountFrom.getBalance() - transferAmount);
					addOrUpdateAccount(accountFrom);
					addOrUpdateAccount(accountTo);
					return "SUCCESS";
				} else 
					return "ID MISATCH";
			}
		} else
			return "ID MISATCH";
	}

	public Account getBalanceOf(int accountNumber) {
		return accountRepository.findByAccountId(accountNumber);
	}

}
