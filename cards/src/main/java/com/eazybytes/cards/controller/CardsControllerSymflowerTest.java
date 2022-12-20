package com.eazybytes.cards.controller;

import com.eazybytes.cards.model.Cards;
import com.eazybytes.cards.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardsControllerSymflowerTest {
	@Test
	public void getCardDetails1() {
		CardsController c = null; // TODO This is a fallback value due to incomplete analysis.
		Customer customer = null; // TODO This is a fallback value due to incomplete analysis.
		List<Cards> expected = null; // TODO This is a fallback value due to incomplete analysis.
		List<Cards> actual = c.getCardDetails(customer);

		assertEquals(expected, actual);
	}

	@Test
	public void getPropertyDetails2() throws JsonProcessingException {
		CardsController c = null; // TODO This is a fallback value due to incomplete analysis.
		String expected = null; // TODO This is a fallback value due to incomplete analysis.
		String actual = c.getPropertyDetails();

		assertEquals(expected, actual);
	}
}
