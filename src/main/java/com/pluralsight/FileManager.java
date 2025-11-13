package com.pluralsight;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class FileManager {


	//most of this is just to avoid hard coding the items and prices. BAD IDEA

	public static void loadItemsToMenu(String csvName) {
		try {
			//adds all to allItems in Menu, stores each line
			FileReader fileReader = new FileReader(csvName);
			System.out.println("File \"" + csvName + "\" successfully opened.");
			BufferedReader buffReader = new BufferedReader(fileReader);
			ArrayList<String> lines = new ArrayList<>();
			String line;

			while((line = buffReader.readLine()) != null) {
				lines.add(line);
				Menu.addToAllItems(new Item(line.split("\\|")[0]));
				System.out.println("Item loaded: " + line.split("\\|")[0]);
			}

			for(String l : lines) {
				String[] lineSplit = l.split("\\|");
				Item newMenuItem = Menu.getFromAll(lineSplit[0]);
				File priceFile;
				ArrayList<Double> prices = new ArrayList<>();
				//todo:this seems bad making a new object every time
				if ( (priceFile = new File(lineSplit[0] + ".csv")).isFile() ) {
					System.out.printf("Price info for %s found.\n", lineSplit[0]);
					prices = loadPrices(lineSplit[0] + ".csv");
					System.out.println("Prices loaded successfully.");
				} else {
					System.out.printf("No price info found for %s.\n", lineSplit[0]);
				}

				for (int j = 1; j < lineSplit.length; j++) {
					newMenuItem.addAvailableOption(lineSplit[j]);
					//todo:this condition is checked every single loop which is
					//unnecessary but who cares at ths point
//					if (!prices.isEmpty()) {
//						System.out.println(j);
//						newMenuItem.getAvailableOptions().get(lineSplit[j]).setBasePrice(prices.get(j-1));
//					}
				}

				if (!prices.isEmpty()) {

				}



				Menu.addToMenuItems(newMenuItem);
				System.out.println("Menu item loaded: " + newMenuItem.getName());

			}

		} catch (Exception ex) {
			System.out.printf("Error occurred, check your %s file.\n", csvName);
			System.out.println(ex);
		}

	} // loadAllItems

	public static ArrayList<Double> loadPrices(String csvName) {

		ArrayList<Double> itemPriceList = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(csvName);
			BufferedReader buffReader = new BufferedReader(fileReader);
			System.out.println("File \"" + csvName + "\" successfully opened.");
			String line;
			//size|size5|size8|size12|size16
			//milk|milkWhole|milkOat|milkAlmond
			//temp|tempHot|tempCold
			//extrashots|oneShot|twoShot|threeShot|fourShot
			//latte|size|milk|temp|extrashots

			while ((line = buffReader.readLine()) != null) {
				for (String s : line.split("\\|")) {
					itemPriceList.add(Double.parseDouble(s));
				}
			}


			return itemPriceList;

		} catch (Exception ex) {
			System.out.printf("Error occurred, check your %s file.\n", csvName);
			System.out.println(ex);
		}
		return itemPriceList;
	}

//	private static ArrayList<Item> getFullOptionTree(Item i) {
//		ArrayList<Item> optionTree = new ArrayList<>();
//		if (!i.getAvailableOptions().isEmpty()) {
//			for (Item i1 : i.getAvailableOptions().values()) {
//				optionTree.addAll(getFullOptionTree(i1));
//			}
//		}
//		return optionTree;
//	}



}




//	public static void saveDealership(Dealership dealershipToSave) {
//		try {
//			FileWriter fileWriter = new FileWriter("inventory.csv");
//			BufferedWriter buffWriter = new BufferedWriter(fileWriter);
//
//			buffWriter.write(dealershipToSave.getName() + "|" + dealershipToSave.getAddress() + "|" + dealershipToSave.getPhoneNumber());
//			buffWriter.newLine();
//
//			for (Vehicle v : dealershipToSave.getAllVehicles()) {
//				buffWriter.write( v.getVin() + "|" +
//						v.getYear() + "|" +
//						v.getColor() + "|" +
//						v.getMake() + "|" +
//						v.getModel() + "|" +
//						v.getVehicleType() + "|" +
//						v.getOdometer() + "|" +
//						v.getPrice());
//				buffWriter.newLine();
//			}
//			buffWriter.close();
//		} catch (Exception ex) {
//			System.out.println(ex + " Exception handling <3");
//		}
//
//
//	} // saveDealership


