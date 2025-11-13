package com.pluralsight;

import java.util.LinkedHashMap;

public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.initProducts();

		ConsoleHelper.consoleClear();

		UserInterface.addTopWindow(new Window(50, 16));
		UserInterface.addTopWindow(new Window(50, 16));

		UserInterface.topWinRow.get(0).printToNextRow("Hello world!");

		UserInterface.displayWindows(UserInterface.topWinRow);


		//menu.getProduct("latte").getAvailableOptions().forEach(option -> System.out.println(option.getName()));



	}

}
