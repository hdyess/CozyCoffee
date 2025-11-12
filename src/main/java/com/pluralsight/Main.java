package com.pluralsight;

import java.util.LinkedHashMap;

public class Main {

	public static void main(String[] args) {

		FileManager.loadItemsToMenu("menuItems.csv");
		System.out.println(Menu.getFromMenu("espresso").getAvailableOptions());


	}

}
