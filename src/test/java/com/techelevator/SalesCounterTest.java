package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SalesCounterTest {

	SalesCounter salesCounter;
	Chip chip1;
	Chip chip2;
	
	@Before
	public void setup() {
		chip1 = new Chip("a1", "chip1", "1.00");
		chip2 = new Chip("a2", "chip2", "1.50");
		Collection<Product> list = new ArrayList<Product>(); 
		list.add(chip1);
		list.add(chip2);
		salesCounter = new SalesCounter(list, "Sales Report Test.txt");
	}
	
	@Test
	public void product_addition_equals_correct() throws IOException {
		int chip1Counter = salesCounter.getMap().get(chip1);
		
		salesCounter.recordSale(chip1);
		salesCounter.recordSale(chip1);
	Assert.assertEquals(chip1Counter + 2, (int)salesCounter.getMap().get(chip1));
		
		
		File file = new File("Sales Report Test.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		Scanner scanner = new Scanner(file);
		String testString = "0";
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains(chip1.getName())) {
				testString = line.split("\\|")[1].trim();
			}
		}
		int testInt = Integer.parseInt(testString);

		
		
		salesCounter.printAllSales();

		File newFile = new File("Sales Report Test.txt");
		Scanner scanner2 = new Scanner(newFile);
		String testString2 = "0";
		while (scanner2.hasNextLine()) {
			String line = scanner2.nextLine();
			if (line.contains(chip1.getName())) {
				testString2 = line.split("\\|")[1].trim();
			}
		}
		int testInt2 = Integer.parseInt(testString2);
		Assert.assertEquals(salesCounter.getMap().get(chip1) + testInt, testInt2);
		scanner.close();
		scanner2.close();
	}
}
