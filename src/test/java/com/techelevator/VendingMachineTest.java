package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Assert;
import org.junit.Test;


public class VendingMachineTest {

	@Test
	public void setup_products_works_correctly() throws IOException {

		File file = new File("testinput.txt");
		FileWriter fileWriter = new FileWriter(file, true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("slot1|chip|1.00|Chip");
		printWriter.println("slot2|candy|1.00|Candy");
		printWriter.println("slot3|gum|1.00|Gum");
		printWriter.println("slot4|drink|1.00|Drink");
		printWriter.flush();
		printWriter.close();
		VendingMachine vendingMachine = new VendingMachine(file);
		Assert.assertEquals(Util.CHIP_NOISE_STRING, vendingMachine.getMap().get("slot1").makeNoise());
		Assert.assertEquals(Util.CANDY_NOISE_STRING, vendingMachine.getMap().get("slot2").makeNoise());
		Assert.assertEquals(Util.GUM_NOISE_STRING, vendingMachine.getMap().get("slot3").makeNoise());
		Assert.assertEquals(Util.DRINK_NOISE_STRING, vendingMachine.getMap().get("slot4").makeNoise());
	}
}
