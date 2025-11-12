package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FileManager {

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

				for (int j = 1; j < lineSplit.length; j++) {
					newMenuItem.addAvailableOption(lineSplit[j]);
				}

				Menu.addToMenuItems(newMenuItem);
				System.out.println("Menu item loaded: " + newMenuItem.getName());

			}

		} catch (Exception ex) {
			System.out.printf("Error occurred, check your %s file.\n", csvName);
		}

	} // loadAllItems






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

}
