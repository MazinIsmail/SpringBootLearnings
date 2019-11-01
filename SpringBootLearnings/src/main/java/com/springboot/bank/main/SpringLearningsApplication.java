package com.springboot.bank.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.springboot.bank.*")
@EntityScan("com.springboot.bank.entity*")
@EnableJpaRepositories("com.springboot.bank.repository*")
public class SpringLearningsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningsApplication.class, args);
	}

}