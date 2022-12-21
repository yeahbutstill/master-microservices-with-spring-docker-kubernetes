package com.yeahbutstill.accounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.yeahbutstill.accounts.config.AccountsServiceConfig;
import com.yeahbutstill.accounts.model.*;
import com.yeahbutstill.accounts.repository.AccountsRepository;
import com.yeahbutstill.accounts.service.client.CardsFeignClient;
import com.yeahbutstill.accounts.service.client.LoansFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/account")
public class AccountsController {

	@Autowired
	AccountsServiceConfig accountsServiceConfig;

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	LoansFeignClient loansFeignClient;

	@Autowired
	CardsFeignClient cardsFeignClient;

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		if (accounts != null) {
			return accounts;
		} else {
			return null;
		}

	}

	@GetMapping("/properties")
	public String getPropertyDetails() throws JsonProcessingException {

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(accountsServiceConfig.getMsg(), accountsServiceConfig.getBuildVersion(),
				accountsServiceConfig.getMailDetails(), accountsServiceConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);

		return jsonStr;

	}

	@PostMapping("/myCustomerDetails")
	@CircuitBreaker(name = "detailsForCustomerSupportApp",fallbackMethod="myCustomerDetailsFallBack")
	@Retry(name = "retryForCustomerDetails", fallbackMethod = "myCustomerDetailsFallBack")
	public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Loans> loans = loansFeignClient.getLoansDetails(customer);
		List<Cards> cards = cardsFeignClient.getCardDetails(customer);

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		customerDetails.setCards(cards);

		return customerDetails;

	}

	private CustomerDetails myCustomerDetailsFallBack(Customer customer, Throwable throwable) {

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Loans> loans = loansFeignClient.getLoansDetails(customer);

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);

		return customerDetails;

	}

	@GetMapping("/sayHello")
	@RateLimiter(name = "sayHello", fallbackMethod = "sayHelloFallback")
	public String sayHello() {
		return "Hello, Welcome to YeahBank";
	}

	private String sayHelloFallback(Throwable throwable) {
		return "Hi, Welcome to YeahBank";
	}

}
