package com.eazybytes.cards.controller;

import com.eazybytes.cards.model.Cards;
import com.eazybytes.cards.model.Customer;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CardsControllerSymflowerTest {
	@Test
	public void getCardDetails1() {
		CardsController c = null; // TODO This is a fallback value due to incomplete analysis.
		Customer customer = null; // TODO This is a fallback value due to incomplete analysis.
		List<Cards> expected = null; // TODO This is a fallback value due to incomplete analysis.
		List<Cards> actual = c.getCardDetails(customer);

		assertEquals(expected, actual);
	}
}
