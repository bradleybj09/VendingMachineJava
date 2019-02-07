package com.techelevator;

public class Drink extends Product {

	public Drink(String slotLocation, String name, String priceString) {
		super(slotLocation, name, priceString, Util.DRINK_NOISE_STRING);
	}

}
