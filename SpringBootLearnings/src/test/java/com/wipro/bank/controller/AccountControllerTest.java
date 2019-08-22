package com.wipro.bank.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.bank.entity.Account;
import com.wipro.bank.service.AccountService;
import com.wipro.bank.service.CustomerService;
import com.wipro.bank.test.helper.TestHelper;

public class AccountControllerTest {

	private static final String FETCH_ALL_ACCOUNTS = "/fetchAllAccounts";
	private static final String FETCH_ALL_CUSTOMERS = "/fetchAllCustomers";

	@InjectMocks
	private AccountController accountController;

	@Mock
	private AccountService accountService;
	
	@Mock
	private CustomerService customerService;

	private MockMvc mockMvc;

	/**
	 * If it is not using the MockitoJUnitRunner class approach, then is need to use
	 * the static method MockitoAnnotations.initMocks(). This method also, upon
	 * initialization of junit tests, initializes the mock objects.
	 */
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
	}

	@Test
	public void fetchAllAccountsTest() throws Exception {
		List<Account> accountListCont = TestHelper.getAccountListData();
		Mockito.when(accountService.getAllAccounts()).thenReturn(accountListCont);
		String json = new ObjectMapper().writeValueAsString(accountListCont);
		mockMvc.perform(get(FETCH_ALL_ACCOUNTS).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Mockito.reset(accountService);

	}
	
	/*
	 * @Test public void fetchAllCustomersTest() throws Exception { List<Customer>
	 * customerListCont = new ArrayList<Customer>();
	 * Mockito.when(accountService.getAllAccounts()).thenReturn(accountListCont);
	 * String json = new ObjectMapper().writeValueAsString(accountListCont);
	 * mockMvc.perform(get(FETCH_ALL_ACCOUNTS).content(json).contentType(MediaType.
	 * APPLICATION_JSON)) .andExpect(status().isOk());
	 * Mockito.reset(accountService);
	 * 
	 * }
	 */

}
