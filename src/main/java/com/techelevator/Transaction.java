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
		String log = logger.logFeedMoney(depositInCents, balanceInCents);
		logger.writeToLog(log);
	}
	
	public boolean purchaseProduct(Product product) {
		if (balanceInCents < product.getPriceInCents()) {
			return false;
		}
		product.decrement();
		balanceInCents -= product.getPriceInCents();
		String log = logger.logProductPurchase(product, balanceInCents);
		logger.writeToLog(log);
		return true;
	}
	
	public void finishTransaction() {
		String log = logger.logGiveChange(balanceInCents);
		logger.writeToLog(log);
		balanceInCents = Util.END_BALANCE_CENTS;
	}
	
	public int[] convertIntoCoins() {
		int numberOfQuarters = balanceInCents/25;
		int remainderAfterQuarters = balanceInCents%25;
		int numberOfDimes = remainderAfterQuarters/10;
		int remainderAfterDimes = remainderAfterQuarters%10;
		int numberOfNickels = remainderAfterDimes/5;
		int[] change = {numberOfQuarters, numberOfDimes, numberOfNickels};
		return change;
	}
}
