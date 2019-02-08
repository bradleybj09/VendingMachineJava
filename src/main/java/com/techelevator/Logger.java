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
	
	public void writeToLog(String string) {
		appendWriter.println(string);
	}
	
	public String logFeedMoney(int moneyDeposited, int balance) {
		String moneyDepositedString = Util.convertCentsToString(moneyDeposited);
		String balanceString = Util.convertCentsToString(balance);
		String string1 = String.format("%-25s",Util.FEED_MONEY_STRING);
		String string2 = moneyDepositedString + "\t" + balanceString;
		return string1 + string2;
	}
	
	public String logProductPurchase(Product product, int balance) {
		String balanceString = Util.convertCentsToString(balance);
		String string1 = String.format("%-25s",product.getNameAndSlot());
		String string2 = product.getPriceString() + "\t" + balanceString;
		return string1 + string2;
}
	
	public String logGiveChange(int balance) {
		String changeString = Util.convertCentsToString(balance - Util.END_BALANCE_CENTS);
		String endBalanceString = Util.convertCentsToString(Util.END_BALANCE_CENTS);
		String string1 = String.format("%-25s",Util.GIVE_CHANGE_STRING);
		String string2 = changeString + "\t" + endBalanceString;
		return string1 + string2;
	}
}
