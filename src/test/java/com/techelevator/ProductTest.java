package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

	@Test
	public void products_make_correct_noise() {
		Chip chip = new Chip("1","2","3");
		Assert.assertEquals(Util.CHIP_NOISE_STRING, chip.makeNoise());
		
		Candy candy = new Candy("1","2","3");
		Assert.assertEquals(Util.CANDY_NOISE_STRING, candy.makeNoise());

		Gum gum = new Gum("1","2","3");
		Assert.assertEquals(Util.GUM_NOISE_STRING, gum.makeNoise());

		Drink drink = new Drink("1","2","3");
		Assert.assertEquals(Util.DRINK_NOISE_STRING, drink.makeNoise());

	}
	
	@Test
	public void product_decrements_correctly() {
		Chip chip = new Chip("1", "2", "3");
		Assert.assertEquals(5, chip.getCount());
		
		chip.decrement();
		Assert.assertEquals(4, chip.getCount());
		
		chip.decrement();
		Assert.assertEquals(3, chip.getCount());

		chip.decrement();
		Assert.assertEquals(2, chip.getCount());

		chip.decrement();
		Assert.assertEquals(1, chip.getCount());

		chip.decrement();
		Assert.assertEquals(0, chip.getCount());
	}

}
