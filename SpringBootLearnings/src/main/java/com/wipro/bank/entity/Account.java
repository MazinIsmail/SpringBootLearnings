package com.wipro.bank.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	@Id
	private int accountID;
	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;
	private double balance;

	public Account() {

	}

	public Account(int accountID, Customer customer, double balance) {
		this.accountID = accountID;
		this.balance = balance;
		this.customer = new Customer(customer.getCustomerID(), customer.getName());
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", customer=" + customer.toString() + ", balance=" + balance + "]";
	}

}
