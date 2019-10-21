package com.springboot.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bank.entity.Customer;
import com.springboot.bank.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		List<Customer> customerstList = customerRepository.findAll();
		return customerstList;

	}

}
