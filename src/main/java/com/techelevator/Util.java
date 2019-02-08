package com.techelevator;

public class Util {
	
	//DO NOT INSTANTIATE
	private Util() {}

	public static final String CHIP_NOISE_STRING = "Crunch Crunch, Yum!";
	public static final String CANDY_NOISE_STRING = "Munch Munch, Yum!";
	public static final String DRINK_NOISE_STRING = "Glug Glug, Yum!";
	public static final String GUM_NOISE_STRING = "Chew Chew, Yum!";
	public static final String FEED_MONEY_STRING = "FEED MONEY:";
	public static final String GIVE_CHANGE_STRING = "GIVE CHANGE:";
	public static final int END_BALANCE_CENTS = 0;
	public static final int START_BALANCE_CENTS = 0;
	public static final String TYPE_CHIP_STRING = "Chip";
	public static final String TYPE_CANDY_STRING = "Candy";
	public static final String TYPE_GUM_STRING = "Gum";
	public static final String TYPE_DRINK_STRING = "Drink";
	public static final String SALES_FILE_STRING = "Sales Report.txt";

	public static int convertStringToCents(String s) {
		return Integer.parseInt(s.replace(".", ""));
	}
	
	public static String convertCentsToString(int i) {
		String dollarString = String.valueOf(i / 100);
		String centsString = String.valueOf(i % 100);
		if (centsString.equals("0")) {
			centsString = "00";
		} else if (centsString.length() == 1) {
			centsString = "0" + centsString;
		}
		return "$" + dollarString + "." + centsString;
	}
}
