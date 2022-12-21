package com.yeahbutstill.loans.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.yeahbutstill.loans.config.LoansServiceConfig;
import com.yeahbutstill.loans.model.Customer;
import com.yeahbutstill.loans.model.Loans;
import com.yeahbutstill.loans.model.Properties;
import com.yeahbutstill.loans.repository.LoansRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/loan")
@Slf4j
public class LoansController {

	@Autowired
	LoansServiceConfig loansServiceConfig;

	@Autowired
	private LoansRepository loansRepository;

	@PostMapping("/myLoans")
	public List<Loans> getLoansDetails(@RequestBody Customer customer) {

		log.info("Invoking Loans Microservices");
		List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		if (loans != null) {
			return loans;
		} else {
			return null;
		}

	}

	@GetMapping("/properties")
	public String getPropertyDetails() throws JsonProcessingException {

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(loansServiceConfig.getMsg(), loansServiceConfig.getBuildVersion(),
				loansServiceConfig.getMailDetails(), loansServiceConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);

		return jsonStr;

	}


}
