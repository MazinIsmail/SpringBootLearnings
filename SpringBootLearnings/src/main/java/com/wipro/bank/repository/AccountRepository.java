package com.wipro.bank.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bank.entity.Account;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {

	public Account findByAccountId(int to);

}
