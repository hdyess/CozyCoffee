package com.pluralsight;

public class AddToBasketWindow extends Window{


	public AddToBasketWindow(int width, int height) {
		super(width, height);
	}
	public void displayAddToBasketWindow(Product product) {
		this.clearRows();

		for (String s : product.toString().split("\\|")) {
			this.printToNextRow(s);
		}


	}

	public String runAddToBasketWindowLogic(Product product) {

		Product productForBasket = product;

		String[] choices = ConsoleHelper.promptForString("Input the options you want for your item: ").split(" ");
		System.out.println(choices);










		this.clearRows();
		this.printToNextRow("Item added successfully, press enter to continue.");


		return "menu";
	}

}
