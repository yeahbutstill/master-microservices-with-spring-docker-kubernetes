package com.yeahbutstill.accounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yeahbutstill.accounts.model.Accounts;
import com.yeahbutstill.accounts.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountsControllerSymflowerTest {
	@Test
	public void getAccountDetails1() {
		AccountsController a = null; // TODO This is a fallback value due to incomplete analysis.
		Customer customer = null; // TODO This is a fallback value due to incomplete analysis.
		Accounts expected = null; // TODO This is a fallback value due to incomplete analysis.
		Accounts actual = a.getAccountDetails(customer);

		assertEquals(expected, actual);
	}

	@Test
	public void getPropertyDetails2() throws JsonProcessingException {
		AccountsController a = null; // TODO This is a fallback value due to incomplete analysis.
		String expected = null; // TODO This is a fallback value due to incomplete analysis.
		String actual = a.getPropertyDetails();

		assertEquals(expected, actual);
	}
}
