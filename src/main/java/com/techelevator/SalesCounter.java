package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class SalesCounter {

	private Map<Product, Integer> map;
	private File salesFile;
	private boolean exists;
	private int priorSales;
	
	public Map<Product, Integer> getMap() {
		return map;
	}
	
	public SalesCounter(Collection<Product> list, String filename) {
		priorSales = 0;
		salesFile = new File(filename);
		if (salesFile.exists()) {
			exists = true;
		}
		map = new HashMap<Product, Integer>();
		for (Product product : list) {
			map.put(product, 0);
		}
	}
	
	public void recordSale(Product product) {
		map.put(product, map.get(product) + 1);
	}
	
	private Map<String, Integer> setupFromPriorFile() throws IOException {
		Scanner scanner = new Scanner(salesFile);
		Map<String, Integer> thisMap = new HashMap<String, Integer>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains("**TOTAL SALES**")) {
				priorSales = Util.convertStringToCents(line.substring(17).trim());
				break;
			} else {
				String[] array = line.split("\\|");
				if (array.length == 1) {
					
				} else {
					String name = array[0].trim();
					int sales = Integer.parseInt(array[1].trim());
					thisMap.put(name, sales); 
				}
			}
		}
		scanner.close();
		return thisMap;
	}
	
	public void printAllSales() {//PULL IN OLD DATA
		
		try {
			Map<String, Integer> thisMap = new HashMap<String, Integer>();
			if (exists) {
				thisMap = setupFromPriorFile(); 
			}
			if (salesFile.exists()) {
				salesFile.delete();
			}
			salesFile.createNewFile();
			FileWriter fileWriter = new FileWriter(salesFile);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			int salesThisSessionInCents = 0;
			for (Entry<Product, Integer> entry : map.entrySet()) {
				String name = entry.getKey().getName();
				int sales = entry.getValue();
				salesThisSessionInCents += entry.getKey().getPriceInCents() * sales;
				if (exists) {
					if (thisMap.containsKey(name)) {
						sales += thisMap.get(name);
					}
				}
				printWriter.printf("%-20s", name);
				printWriter.println("| " + sales);
			}
			printWriter.println("\n**TOTAL SALES** " + Util.convertCentsToString(salesThisSessionInCents + priorSales));
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			System.out.println("SALES FILE FAILED TO PRINT");
			e.printStackTrace();
		}
	}
}
