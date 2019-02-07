package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

	private File logFile;
	private FileWriter fileWriter;
	private PrintWriter appendWriter;
	
	public Logger() throws IOException {
		logFile = new File("Log.txt");
		fileWriter = new FileWriter(logFile, true);
		appendWriter = new PrintWriter(fileWriter);
		appendWriter.flush();
		appendWriter.close();
	}
	
	public void logFeedMoney(int moneyDeposited, int balance) {
		String moneyDepositedString = Util.convertCentsToString(moneyDeposited);
		String balanceString = Util.convertCentsToString(balance);
		appendWriter.println(Util.FEED_MONEY_STRING + "\t" + moneyDepositedString + "\t" + balanceString);
		appendWriter.flush();
		appendWriter.close();
	}
	
	public void logProductPurchase(Product product, int balance) {
		String balanceString = Util.convertCentsToString(balance);
		appendWriter.println(product.getNameAndSlot() + "\t" + product.getPriceString() + "\t" + balanceString);
		appendWriter.flush();
		appendWriter.close();
}
	
	public void logGiveChange(int balance) {
		String changeString = Util.convertCentsToString(balance - Util.END_BALANCE_CENTS);
		String endBalanceString = Util.convertCentsToString(Util.END_BALANCE_CENTS);
		appendWriter.println(Util.GIVE_CHANGE_STRING + "\t" + changeString + "\t" + endBalanceString);
		appendWriter.flush();
		appendWriter.close();
	}
}
