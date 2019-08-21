package com.wipro.test.helper;

import com.wipro.bank.entity.Account;

public class TestHelper {

	public static Account getAccountRequest() {
		Account account = new Account();
		account.setAccountId(10);
		account.setBalance(500.0);
		return null;
	}
}
