package com.techelevator;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest {

	Logger logger;
	
	@Before
	public void setup() throws IOException {
		logger = new Logger();
	}
	
	@Test
	public void log_feed_money_correct() {
		String logString = logger.logFeedMoney(1000, 1000);
		Assert.assertEquals("FEED MONEY:              $10.00	$10.00", logString);
	}
	
	@Test
	public void log_product_purchase_correct() {
		Chip product = new Chip("slot1", "chip", "1.00");
		String logString = logger.logProductPurchase(product, 100);
		Assert.assertEquals("chip slot1               1.00	$1.00", logString);
	}

	@Test
	public void log_GiveChange_correct() {
		int balance = 242;
		String logString = logger.logGiveChange(balance);
		Assert.assertEquals("GIVE CHANGE:             $2.42	$0.00", logString);
	}

}
