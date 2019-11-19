package com.springboot.bank.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
@Aspect
public class AccountAspect {

	@Before(value = "execution(* com.springboot.bank.service.AccountServiceImpl.*(..))")
	public void beforeAdvice() {
		System.out.println("Before executing Advice");
	}

	@Before(value = "execution(com.springboot.bank.service.AccountServiceImpl.getBalanceOf(*))")
	public void beforeAdviceAgain() {
		System.out.println("Before executing Advice");
	}

	@After(value = "execution(* com.springboot.bank.service.AccountServiceImpl.*(..))")
	public void afterAdvice() {
		System.out.println("After executing Advice");
	}

	//
}
