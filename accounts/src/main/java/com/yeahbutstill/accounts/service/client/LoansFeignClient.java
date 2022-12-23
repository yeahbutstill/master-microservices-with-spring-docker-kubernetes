package com.yeahbutstill.accounts.service.client;

import com.yeahbutstill.accounts.model.Customer;
import com.yeahbutstill.accounts.model.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {

	@PostMapping(value = "myLoans", consumes = "application/json")
	List<Loans> getLoansDetails(@RequestHeader("eazybank-correlation-id") String correlationid,@RequestBody Customer customer);
}