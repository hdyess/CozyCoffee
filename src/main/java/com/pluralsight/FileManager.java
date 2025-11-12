package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {

	public static void loadItemsToMenu(String csvName) {
		try {

			FileReader fileReader = new FileReader(csvName);
			BufferedReader buffReader = new BufferedReader(fileReader);
			String line;

			while ((line = buffReader.readLine()) != null) {
				String[] lineParsed = line.split("\\|");
				Menu.addToAllItems(new Item(lineParsed[0], Double.parseDouble(lineParsed[1]) ) );
			}

		} catch (Exception ex) {
			System.out.printf("Error occurred, check your %s file.", csvName);
		}

	} // loadItem

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
