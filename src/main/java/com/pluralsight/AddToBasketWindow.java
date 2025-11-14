package com.pluralsight;

public class AddToBasketWindow extends Window{


	public AddToBasketWindow(int width, int height) {
		super(width, height);
	}
	public void displayAddToBasketWindow(Product product) {
		this.printToNextRow(product.getName());
	}

	public String runAddToBasketWindowLogic(Product product) {
		return ConsoleHelper.promptForString("Input item name to add item, or any other input to return: ");
	}

}
