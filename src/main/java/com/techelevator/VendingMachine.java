package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

	private Map<String, Product> map;
	private Logger logger;
	
	public VendingMachine(File inputFile) throws IOException {
		map = new HashMap<String, Product>();
		logger = new Logger();
		setupProducts(inputFile);
	}
	
	public Logger getLogger() {
		return logger;
	}
	
	public Map<String, Product> getMap() {
		return map;
	}
	
	private void setupProducts(File inputFile) throws FileNotFoundException {
		Scanner scanner = new Scanner(inputFile);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] array = line.split("\\|");
			makeAndAddProduct(array);
		}
		scanner.close();
	}
	
	private void makeAndAddProduct(String[] array) {
		String slotLocation = array[0];
		String name = array[1];
		String priceString = array[2];
		String type = array[3];
		switch (type) {
		case Util.TYPE_CHIP_STRING:
			map.put(slotLocation, new Chip(slotLocation, name, priceString));
			break;
		case Util.TYPE_CANDY_STRING:
			map.put(slotLocation, new Candy(slotLocation, name, priceString));
			break;
		case Util.TYPE_DRINK_STRING:
			map.put(slotLocation, new Drink(slotLocation, name, priceString));
			break;
		case Util.TYPE_GUM_STRING:
			map.put(slotLocation, new Gum(slotLocation, name, priceString));
			break;		
		}
	}	
}
