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
import com.wipro.bank.entity.Customer;
import com.wipro.bank.model.FundTransfer;
import com.wipro.bank.service.AccountServiceImpl;
import com.wipro.bank.service.CustomerServiceImpl;
import com.wipro.bank.test.helper.TestHelper;

public class AccountControllerTest {

	private static final String FETCH_ALL_ACCOUNTS = "/fetchAllAccounts";
	private static final String FETCH_ALL_CUSTOMERS = "/fetchAllCustomers";
	private static final String ADD_ACCOUNT = "/addAccount";
	private static final String INITIALIZE_ACCOUNT = "/intializeAccounts";
	private static final String TRANSFER_FUNDS = "/transferFunds";
    private static final String FETCH_ACCOUNT_BALANCE = "/getAccountBalance/{acNumber}";

	@InjectMocks
	private AccountController accountController;

	@Mock
	private AccountServiceImpl accountService;

	@Mock
	private CustomerServiceImpl customerService;

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

	/**
	 * It is need to reset mock between tests because the mock objects are managed
	 * by the Spring container. If it is not reset, stubbing and verified behavior
	 * would "leak" from one test to another.
	 */

	@Test
	public void fetchAllAccountsTest() throws Exception {
		List<Account> accountListCont = TestHelper.getAccountListData();
		Mockito.when(accountService.getAllAccounts()).thenReturn(accountListCont);
		String json = new ObjectMapper().writeValueAsString(accountListCont);
		mockMvc.perform(get(FETCH_ALL_ACCOUNTS).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Mockito.reset(accountService);

	}

	@Test
	public void intializeAccountsTest() throws Exception {
		List<Account> accountListCont = TestHelper.getAccountListData();
		Mockito.when(accountService.addAllAccount(accountListCont)).thenReturn(accountListCont);
		String json = new ObjectMapper().writeValueAsString(accountListCont);
		mockMvc.perform(get(INITIALIZE_ACCOUNT).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Mockito.reset(accountService);
	}

	@Test
	public void transferFundsTest() throws Exception {
		int fromAccount = 10;
		int toAccount = 20;
		double transferAmount = 500;
		FundTransfer fundTransfer = TestHelper.fundTransferData();
		String success = "SUCCESS";
		Mockito.when(accountService.transferFunds(fromAccount, toAccount, transferAmount)).thenReturn(success);
		String json = new ObjectMapper().writeValueAsString(fundTransfer);
		mockMvc.perform(post(TRANSFER_FUNDS).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Mockito.reset(accountService);

	}

	@Test
	public void addAccountTest() throws Exception {
		Account addAccount = TestHelper.getAccountData1();
		Mockito.when(accountService.addOrUpdateAccount(addAccount)).thenReturn(addAccount);
		String json = new ObjectMapper().writeValueAsString(addAccount);
		mockMvc.perform(post(ADD_ACCOUNT).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Mockito.reset(accountService);
	}

	@Test
	public void fetchAllCustomersTest() throws Exception {
		List<Customer> customerListCont = TestHelper.getCustomerListData();
		Mockito.when(customerService.getAllCustomers()).thenReturn(customerListCont);
		String json = new ObjectMapper().writeValueAsString(customerListCont);
		mockMvc.perform(get(FETCH_ALL_CUSTOMERS).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Mockito.reset(customerService);
	}

	@Test
	public void getAccountBalanceTest() throws Exception {
		int accountNumber = TestHelper.getAccountData1().getAccountId();
		Account account = TestHelper.getAccountData1();
		Mockito.when(accountService.getBalanceOf(accountNumber)).thenReturn(account);
		String json = new ObjectMapper().writeValueAsString(accountNumber);
		mockMvc.perform(get(FETCH_ACCOUNT_BALANCE, accountNumber).content(json)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		Mockito.reset(accountService);
	}

}
