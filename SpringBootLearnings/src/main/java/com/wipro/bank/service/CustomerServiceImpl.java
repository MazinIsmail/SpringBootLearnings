package com.wipro.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bank.entity.Customer;
import com.wipro.bank.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		List<Customer> customerstList = customerRepository.findAll();
		return customerstList;

	}

}
