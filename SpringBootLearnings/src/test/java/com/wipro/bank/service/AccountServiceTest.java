package com.wipro.bank.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.bank.entity.Account;
import com.wipro.bank.entity.Customer;
import com.wipro.bank.repository.AccountRepository;
import com.wipro.bank.test.helper.TestHelper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { AccountServiceImpl.class })
public class AccountServiceTest {

	@Autowired
	private AccountServiceImpl accountService;

	@MockBean
	private AccountRepository mockAccountRepository;

	@Test
	public void addAllAccountsTest() {
		List<Account> accountList = TestHelper.getAccountListData();
		Mockito.when(mockAccountRepository.saveAll(accountList)).thenReturn(accountList);
		List<Account> accountSuccess1 = accountService.addAllAccount(accountList);
		assertEquals(1, accountSuccess1.size());
	}

	@Test
	public void addOrUpdateAccountTest() {
		Account account = TestHelper.getAccountData1();
		Mockito.when(mockAccountRepository.save(account)).thenReturn(account);
		Account accountResult = accountService.addOrUpdateAccount(account);
		assertEquals(account.getAccountId(), accountResult.getAccountId());
	}

	@Test
	public void getAllAccountsTest() {
		List<Account> accountList = TestHelper.getAccountListData();
		Mockito.when(mockAccountRepository.findAll()).thenReturn(accountList);
		List<Account> accountSuccess1 = accountService.getAllAccounts();
		assertEquals(1, accountSuccess1.size());
	}

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
		double transferAmount = 500;
		Customer customerObj = TestHelper.getCustomerData1();
		Account accountFrom = TestHelper.getAccountData1();
		Account accountTo = TestHelper.getAccountData2();
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
		 * a mock object has been called by specific number of times and also to verify
		 * mock methods has been invoked and executed while executing the actual test
		 * classes.
		 */
		// Mockito.verify(mockAccountRepository,
		// times(1)).findByAccountId(accountFromId);
		// Here, in this example, it is called twice(times(2)). So, it needs to write
		// Mockito condition also twice
		Mockito.verify(mockAccountRepository, times(2)).findByAccountId(accountFromId);

		assertEquals(accountSuccess, "SUCCESS");
		assertEquals(accountSuccess1, "INSUFFICIENT FUNDS");
	}

}
