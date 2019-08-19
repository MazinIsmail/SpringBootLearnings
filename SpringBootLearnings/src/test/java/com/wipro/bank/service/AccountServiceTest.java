package com.wipro.bank.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.bank.entity.Account;

@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountServiceTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AccountService accountService;

	@Test
	public void testRecordsWhenEmpty() {
		Iterable<Account> products = accountService.getAllAccounts();
		assertThat(products).isEmpty();
	}
}
