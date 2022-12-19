package com.yeahbutstill.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScans({ @ComponentScan("com.yeahbutstill.accounts.controller") })
//@EnableJpaRepositories("com.yeahbutstill.accounts.repository")
//@EntityScan("com.yeahbutstill.accounts.model")
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}
}
