package com.pluralsight;

import java.util.LinkedHashMap;

public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.initProducts();

		ConsoleHelper.consoleClear();

		UserInterface.addTopWindow(new Window(50, 10));
		UserInterface.addTopWindow(new Window(50, 10));

		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");

		UserInterface.getTopWinRow().get(1).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(1).printToNextRow("Hello world!");


		UserInterface.displayWindows(UserInterface.getTopWinRow());

		UserInterface.getTopWinRow().get(0).clearRows();
		UserInterface.getTopWinRow().get(1).clearRows();

		UserInterface.displayWindows(UserInterface.getTopWinRow());

		UserInterface.getTopWinRow().get(0).clearRows();
		UserInterface.getTopWinRow().get(1).clearRows();

		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");

		UserInterface.displayWindows(UserInterface.getTopWinRow());

		UserInterface.getTopWinRow().get(0).clearRows();
		UserInterface.getTopWinRow().get(1).clearRows();

		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");
		UserInterface.getTopWinRow().get(0).printToNextRow("Hello world!");

		UserInterface.displayWindows(UserInterface.getTopWinRow());

		UserInterface.getTopWinRow().get(0).clearRows();
		UserInterface.getTopWinRow().get(1).clearRows();




	}

}
