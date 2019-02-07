package com.techelevator;

import java.io.File;
import java.io.IOException;

public class VendingMachineProgram {

	public static void main(String[] args) throws IOException {
		File file = new File("vendingmachine.csv");
		VendingMachine vendingMachine = new VendingMachine(file);
		boolean programActive = true;
		boolean isMainMenu = true;
		Menu menu = new Menu();
		
		while(programActive) {
			if (isMainMenu) {
				menu.displayMainMenu();
				int choice = menu.getMenuChoice();
				if (choice == -1) {	
				} else if (choice == 3) {
					menu.displayCloseMessage();
					programActive = false;
				} else if (choice == 1) {
					menu.displayContents(vendingMachine.getMap().values());
					menu.waitForEnter();
				} else if (choice == 2) {
					isMainMenu = false;
				}
			} else {
				Transaction transaction = new Transaction(vendingMachine.getLogger());
				boolean transactionActive = true;
				while (transactionActive) {
					menu.displayTransactionMenu(transaction);
					int choice = menu.getMenuChoice();
					if (choice == 1) {
						int deposit = menu.getFeedMoney();
						if (deposit == -1) {

						} else {
							transaction.feedMoney(deposit);
						}
					} else if (choice == 2) {
						menu.displayContents(vendingMachine.getMap().values());
						Product choiceProduct = menu.getProductChoice(vendingMachine.getMap());
						if (choiceProduct == null) {

						} else {
							boolean success = transaction.purchaseProduct(choiceProduct);
							if (!success) {
								menu.displayNotEnoughMoney();
							} else {
								menu.makeNoise(choiceProduct);
							}
						}
					} else if (choice == 3) {
						transaction.finishTransaction();
						transactionActive = false;
						isMainMenu = true;
					}
				}
			}
		}
	}
}
