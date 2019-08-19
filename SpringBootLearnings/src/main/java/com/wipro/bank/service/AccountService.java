package com.wipro.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bank.entity.Account;
import com.wipro.bank.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public Account addAccount(Account ac) {
		return accountRepository.save(ac);
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
					return "SUCCESS”";
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
