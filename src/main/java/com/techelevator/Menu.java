package com.techelevator;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class Menu {
	
	Scanner scanner;
	
	public Menu() {
		scanner = new Scanner(System.in);
	}
	
	public void cleanup() {
	//	scanner.close();
	}

	public void displayMainMenu() {
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");
	}
	
	public void displayTransactionMenu(Transaction transaction) {
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction");
		System.out.println("Current Money Provided: " + Util.convertCentsToString(transaction.getBalanceInCents()));
	}

	public int getMenuChoice() {
		String userInput = scanner.nextLine();
		try {
			int test = Integer.parseInt(userInput);
			if (test == 1 || test == 2 || test == 3) {
				return test;
			} else {
				System.out.println("You must enter an integer between 1 and 3");
				return -1;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("You must enter an integer between 1 and 3");
			return -1;
		}
	}
	
	public int getFeedMoney() {
		System.out.println("Please enter the amount you wish to add to your balance (1, 2, 5, or 10):");
		String userInput = scanner.nextLine();
		if (userInput.equals("1") || userInput.equals("2") || userInput.equals("5") || userInput.equals("10")) {
			return Util.convertStringToCents(userInput) * 100;
		} else {
			System.out.println("You must enter 1, 2, 5, or 10.");
			return -1;
		}
	}
	
	public Product getProductChoice(Map<String, Product> map) {
		System.out.println("Please enter the slot number of the product you wish to purchase");
		String userInput = scanner.nextLine();
		if (map.containsKey(userInput) && map.get(userInput).getCount() != 0) {
			return map.get(userInput);
		} else {
			System.out.println("You have entered an empty or nonextistent slot.");
			return null;
		}
	}
	
	public void displayContents(Collection<Product> products) {
		for (Product product : products) {
			String stockString = "";
			if (product.getCount() > 0) {
				stockString = String.valueOf(product.getCount());
			} else {
				stockString = "Sold Out!";
			}
			System.out.print(product.getSlotNumber() + "\t");
			System.out.format("%-20s", product.getName());
			System.out.println("$" + product.getPriceString() + "\t\t" + "Stock: " + stockString);
		}
	}
	
	public void displayChangeInCoins(int[] coins) {
		System.out.println("Your change is: ");
		System.out.println(coins[0] + " Quarter(s)");
		System.out.println(coins[1] + " Dime(s)");
		System.out.println(coins[2] + " Nickel(s)");
	}
	
	public void makeNoise(Product product) {
		System.out.println(product.makeNoise());
	}
	
	public void displayNotEnoughMoney() {
		System.out.println("You do not have enough money for this item!");
	}
	
	public void waitForEnter() {
		System.out.println("--Press enter to return to main menu--");
		scanner.nextLine();
	}
	
	public void displayCloseMessage() {
		System.out.println("Vending machine closing. Will I dream?");
	}

}
