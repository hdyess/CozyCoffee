package com.pluralsight;

import java.util.LinkedHashMap;

public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.initProducts();

		UserInterface.addTopWindow(new Window(100, 100));
		UserInterface.addTopWindow(new Window(100, 100));

		UserInterface.displayWindows(UserInterface.topWinRow);


		//menu.getProduct("latte").getAvailableOptions().forEach(option -> System.out.println(option.getName()));



	}

}
