package com.techelevator;

public class Candy extends Product {

	public Candy(String slotLocation, String name, String priceString) {
		super(slotLocation, name, priceString, Util.CANDY_NOISE_STRING);
	}

}
