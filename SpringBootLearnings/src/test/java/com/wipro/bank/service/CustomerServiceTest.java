package com.wipro.bank.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.bank.entity.Customer;
import com.wipro.bank.repository.CustomerRepository;
import com.wipro.bank.test.helper.TestHelper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { CustomerService.class })
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepository mockCustomerRepository;

	/**
	 * Checking the size of Customer List. Checking the size of Customer List as 2
	 * and the actual size of Customer List is also 2. Test Result Success.
	 */
	@Test
	public void getAllCustomersTest() {
		List<Customer> customerList = TestHelper.getCustomerListData();
		Mockito.when(mockCustomerRepository.findAll()).thenReturn(customerList);
		List<Customer> customerSuccess1 = customerService.getAllCustomers();
		assertEquals(2, customerSuccess1.size());
	}

}
