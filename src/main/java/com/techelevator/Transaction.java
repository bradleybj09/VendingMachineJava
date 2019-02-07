package com.techelevator;

public class Transaction {

	private int balanceInCents;
	private Logger logger;
	
	public int getBalanceInCents() {
		return balanceInCents;
	}
	
	public Transaction(Logger logger) {
		balanceInCents = Util.START_BALANCE_CENTS;
		this.logger = logger;
	}
	
	public void feedMoney(int depositInCents) {
		balanceInCents += depositInCents;
		logger.logFeedMoney(depositInCents, balanceInCents);
	}
	
	public boolean purchaseProduct(Product product) {
		if (balanceInCents < product.getPriceInCents()) {
			return false;
		}
		product.decrement();
		balanceInCents -= product.getPriceInCents();
		logger.logProductPurchase(product, balanceInCents);
		return true;
	}
	
	public void finishTransaction() {
		logger.logGiveChange(balanceInCents);
		balanceInCents = Util.END_BALANCE_CENTS;
	}
}
