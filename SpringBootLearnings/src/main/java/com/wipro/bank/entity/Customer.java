package com.wipro.bank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	private int customerId;
	
	@OneToOne(mappedBy="customer")
	private Account account;
	
	private String name;

	public Customer() {

	}

	public Customer(int id, String name) {
		this.customerId = id;
		this.name = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerId + ", name=" + name + "]";
	}

}
