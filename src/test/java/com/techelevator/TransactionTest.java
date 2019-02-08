package com.techelevator;

import org.junit.Assert;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest {

	Transaction transaction;
	Logger logger;

	@Before
	public void setup() throws IOException {
		logger = new Logger();
		transaction = new Transaction(logger);
	}

	@Test
	public void convertIntoCoins_correct_0_balance() {
		int[] coins = new int[] { 0, 0, 0 };

		Assert.assertArrayEquals(coins, transaction.convertIntoCoins());

	}

	@Test
	public void convertIntoCoins_correct_65Cents_balance() {
		int[] coins = new int[] { 2, 1, 1 };
		transaction.feedMoney(65);

		Assert.assertArrayEquals(coins, transaction.convertIntoCoins());

	}

	@Test
	public void convertIntoCoins_correct_155Cents_balance() {
		int[] coins = new int[] { 6, 0, 1 };
		transaction.feedMoney(155);

		Assert.assertArrayEquals(coins, transaction.convertIntoCoins());

	}
	
	@Test
	public void purchase_not_enough_equals_false() {
		Chip chip = new Chip("a1","chip","1.00");
		boolean b = transaction.purchaseProduct(chip);
		Assert.assertFalse(b);
		
	}
	
	@Test
	public void purchase_enough_equals_true() {
		Chip chip = new Chip("a1","chip","1.00");
		transaction.feedMoney(500);
		boolean b = transaction.purchaseProduct(chip);
		Assert.assertTrue(b);
		
	}

}
