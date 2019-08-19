package com.wipro.bank.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.wipro.bank*")
@EntityScan("com.wipro.bank.entity*")
@EnableJpaRepositories("com.wipro.bank.repository*")
public class SpringLearningsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningsApplication.class, args);
	}

}