package com.techelevator;

public abstract class Product {

	private int count;
	private String name;
	private int priceInCents;
	private String priceString;
	private String slotLocation;
	private String noise;
	
	public Product(String slotLocation, String name, String priceString, String noise) {
		count = 5;
		this.slotLocation = slotLocation;
		this.name = name;
		this.priceString = priceString;
		this.noise = noise;
		priceInCents = Util.convertStringToCents(priceString);
	}
	
	public String getPriceString() {
		return priceString;
	}
	
	public String makeNoise() {
		return noise;
	}
	
	public void decrement() {
		count--;
	}
	
	public String getSlotNumber() {
		return slotLocation;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNameAndSlot() {
		return name + " " + slotLocation;
	}
	
	public int getPriceInCents() {
		return priceInCents;
	}
	
	public int getCount() {
		return count;
	}
}
