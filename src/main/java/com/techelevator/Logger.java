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
		if (logFile.exists()) {
			logFile.delete();
		}
		logFile.createNewFile();
		fileWriter = new FileWriter(logFile, true);
		appendWriter = new PrintWriter(fileWriter);
	}
	
	public void close() {
		appendWriter.flush();
		appendWriter.close();
	}
	
	public void logFeedMoney(int moneyDeposited, int balance) {
		String moneyDepositedString = Util.convertCentsToString(moneyDeposited);
		String balanceString = Util.convertCentsToString(balance);
		appendWriter.format("%-25s",Util.FEED_MONEY_STRING);
		appendWriter.println(moneyDepositedString + "\t" + balanceString);
	}
	
	public void logProductPurchase(Product product, int balance) {
		String balanceString = Util.convertCentsToString(balance);
		appendWriter.format("%-25s",product.getNameAndSlot());
		appendWriter.println(product.getPriceString() + "\t" + balanceString);
}
	
	public void logGiveChange(int balance) {
		String changeString = Util.convertCentsToString(balance - Util.END_BALANCE_CENTS);
		String endBalanceString = Util.convertCentsToString(Util.END_BALANCE_CENTS);
		appendWriter.format("%-25s",Util.GIVE_CHANGE_STRING);
		appendWriter.println(changeString + "\t" + endBalanceString);
	}
}
