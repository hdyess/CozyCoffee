package com.pluralsight;

public class MenuWindow extends Window{

	public static Menu menu;


	public MenuWindow(int width, int height) {
		super(width, height);
	}

	public void displayMenuWindow() {
		menu = new Menu();
		menu.initProducts();
		ConsoleHelper.consoleClear();

		this.printToNextRow("All items: ");

		for(Product p : menu.getProductMap().values()) {
			this.printToNextRow( p.getName());
		}

	}

	public String runMenuLogic()	{
		return ConsoleHelper.promptForString("Input item name to add item, or any other input to return: ");
	}




}
