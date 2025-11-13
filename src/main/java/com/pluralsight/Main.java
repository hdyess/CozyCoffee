package com.pluralsight;

import java.util.LinkedHashMap;

public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.initProducts();

		UserInterface.addTopWindow(new Window(70, 20));
		UserInterface.addTopWindow(new Window(50, 20));
		UserInterface.addBottomWindow(new Window(120, 2));

		for(String s : menu.getProductNames() ) {
			UserInterface.getTopWinRow().get(1).printToNextRow(s);
		}

		UserInterface.displayWindows(UserInterface.getTopWinRow());
		UserInterface.displayWindows(UserInterface.getBottomWinRow());




	}

}
