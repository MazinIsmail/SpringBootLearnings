package com.wipro.bank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	private int customerID;
	
	@OneToOne(mappedBy="customer")
	private Account account;
	
	private String name;

	public Customer() {

	}

	public Customer(int id, String name) {
		this.customerID = id;
		this.name = name;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + "]";
	}

}
