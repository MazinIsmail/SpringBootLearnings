package com.wipro.bank.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.bank.entity.Account;
import com.wipro.bank.repository.AccountRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { AccountService.class })
public class AccountServiceTest {

	@Autowired
	private AccountService accountService;

	@MockBean
	private AccountRepository mockAccountRepository;

	/*
	 * @Test public void testRecordsWhenEmpty() { Iterable<Account> products =
	 * accountService.getAllAccounts(); assertThat(products).isEmpty(); }
	 */

	/*
	 * @Test public void addAllAccountTest() { List<Account> accountList = new
	 * ArrayList<>();
	 * Mockito.when(mockAccountRepository.saveAll(Mockito.any(List<Account>))).
	 * thenReturn(serviceResponse);
	 * 
	 * 
	 * List<Account> accountSuccess = accountService.addAllAccount(accountList);
	 * 
	 * 
	 * 
	 * Mockito.verify(mockPcCalcRestHandler,
	 * VerificationModeFactory.times(1)).invokePcCalcRestService(serviceRequest);
	 * Mockito.reset(mockPcCalcRestHandler);
	 * 
	 * }
	 */

	/*
	 * @Test public void addAllAccountTest() {
	 * 
	 * 
	 * Account acc = new Account(); List<Account> accountList = new ArrayList<>();
	 * // Mockito.when(mockAccountRepository.saveAll(Mockito.any(List<Account>))).
	 * // thenReturn(serviceResponse);
	 * Mockito.when(mockAccountRepository.saveAllAccount(accountList)).thenReturn(
	 * acc); // List<String> mockList = mock(List.class); //
	 * when(accountList.size()).thenReturn(5); assertTrue(accountList.size() == 5);
	 * 
	 * 
	 * List<Account> accountList = new ArrayList<>();
	 * Mockito.when(mockAccountRepository.saveAllAccount(accountList)).thenReturn(
	 * serviceResponse);
	 * 
	 * }
	 */
	
	public void addAllAccountsTest() {
		      
		List<Account> accountList = new ArrayList<>();
        Account accountAll = new Account();
        accountAll.setAccountId(1);
        accountAll.setBalance(500.0);
        accountList.add(accountAll);
        when(mockAccountRepository.saveAll(accountList)).thenReturn(accountList);
        		
        		/*
		 * Copyright 2019 the original author or authors.
		 *
		 * Licensed under the Apache License, Version 2.0 (the "License");
		 * you may not use this file except in compliance with the License.
		 * You may obtain a copy of the License at
		 *
		 *      http://www.apache.org/licenses/LICENSE-2.0
		 *
		 * Unless required by applicable law or agreed to in writing, software
		 * distributed under the License is distributed on an "AS IS" BASIS,
		 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
		 * See the License for the specific language governing permissions and
		 * limitations under the License.
		 */
))
	}

	/*
	 * private List<Account> asList(Account accountAllList) { // TODO Auto-generated
	 * method stub return null; }
	 */

	@Test
	public void getBalanceOfTest() {
		int accountNumber = 1012;
		Account accNum = new Account();
		Mockito.when(mockAccountRepository.findByAccountId(accountNumber)).thenReturn(accNum);
		Account accountSuccess = accountService.getBalanceOf(accountNumber);
		assertEquals(accountSuccess, accNum);
	}

	@Test
	public void transferFundsTest() {
		int accountFromId = 1;
		int accountToId = 2;
		double transferAmount = 5000;
		Account accountFrom = new Account();
		Account accountTo = new Account();
		// Account transAmount = new Account();
		Mockito.when(mockAccountRepository.findByAccountId(accountFromId)).thenReturn(accountFrom);
		Mockito.when(mockAccountRepository.findByAccountId(accountToId)).thenReturn(accountTo);
		// Mockito.when(mockAccountRepository.findByAccountTrans(transferAmount)).thenReturn(transAmount);
		String accountSuccess = accountService.transferFunds(accountFromId, accountToId, transferAmount);

		Mockito.when(mockAccountRepository.findByAccountId(accountFromId)).thenReturn(accountFrom);
		Mockito.when(mockAccountRepository.findByAccountId(accountToId)).thenReturn(accountTo);
		String accountSuccess1 = accountService.transferFunds(accountFromId, accountToId, transferAmount);

		/*
		 * Mockito.verify(mockAccountRepository,
		 * VerificationModeFactory.times(1)).findByAccountId(accountFromId);
		 * Mockito.verify(mockAccountRepository,
		 * VerificationModeFactory.times(1)).findByAccountId(accountToId);
		 * Mockito.reset(mockAccountRepository);
		 */
		/**
		 * Verify in Mockito simply means that you want to check if a certain method of
		 * a mock object has been called by specific number of times
		 */
		// Mockito.verify(mockAccountRepository,
		// times(1)).findByAccountId(accountFromId);
		// Here, in this example, it is called twice(times(2)). So, it needs to write
		// Mockito condition also twice
		Mockito.verify(mockAccountRepository, times(2)).findByAccountId(accountFromId);

		assertEquals(accountSuccess, "INSUFFICIENT FUNDS");
		assertEquals(accountSuccess1, "INSUFFICIENT FUNDS");
	}

}
