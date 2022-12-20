package com.yeahbutstill.loans.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yeahbutstill.loans.model.Customer;
import com.yeahbutstill.loans.model.Loans;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoansControllerSymflowerTest {
	@Test
	public void getLoansDetails1() {
		LoansController l = null; // TODO This is a fallback value due to incomplete analysis.
		Customer customer = null; // TODO This is a fallback value due to incomplete analysis.
		List<Loans> expected = null; // TODO This is a fallback value due to incomplete analysis.
		List<Loans> actual = l.getLoansDetails(customer);

		assertEquals(expected, actual);
	}

	@Test
	public void getPropertyDetails2() throws JsonProcessingException {
		LoansController l = null; // TODO This is a fallback value due to incomplete analysis.
		String expected = null; // TODO This is a fallback value due to incomplete analysis.
		String actual = l.getPropertyDetails();

		assertEquals(expected, actual);
	}
}
