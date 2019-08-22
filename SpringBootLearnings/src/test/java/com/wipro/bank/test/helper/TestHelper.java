package com.wipro.bank.test.helper;

import java.util.ArrayList;
import java.util.List;

import com.wipro.bank.entity.Account;
import com.wipro.bank.entity.Customer;
import com.wipro.bank.model.FundTransfer;

public class TestHelper {

	public static Account getAccountData1() {
		Account accountAll = new Account();
		Customer customerObj = new Customer(1, "Test");
		accountAll.setAccountId(1);
		accountAll.setBalance(500.0);
		accountAll.setCustomer(customerObj);
		return accountAll;
	}

	public static Account getAccountData2() {
		Account accountAll = new Account();
		Customer customerObj = new Customer(1, "Test");
		accountAll.setAccountId(2);
		accountAll.setBalance(1500.0);
		accountAll.setCustomer(customerObj);
		return accountAll;
	}
	
	public static List<Account> getAccountListData() {
		List<Account> accountList = new ArrayList<>();
		Account accountAll = getAccountData1();
		accountList.add(accountAll);
		return accountList;
	}

	public static int getBalance(int bal) {
		int balance = 1500;
		return balance;
	}
	
	public static Customer getCustomerData1() {
		Customer customerObj = new Customer(1, "Customer1");
		return customerObj;
	}
	
	public static Customer getCustomerData2() {
		Customer customerObj = new Customer(2, "Customer2");
		return customerObj;
	}
	
	public static List<Customer> getCustomerListData() {
		List<Customer> customerList = new ArrayList<>();
		Customer customerAll = getCustomerData1();
		Customer customerAll2 = getCustomerData2();
		customerList.add(customerAll);
		customerList.add(customerAll2);
		return customerList;
	}

	public static FundTransfer fundTransferData() {
		FundTransfer fundTransferData = new FundTransfer(10,20,2000);
		return fundTransferData;
	}

}
