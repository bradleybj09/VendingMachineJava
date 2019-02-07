package com.techelevator;

public class Chip extends Product {

	public Chip(String slotLocation, String name, String priceString) {
		super(slotLocation, name, priceString, Util.CHIP_NOISE_STRING);
	}	
}
