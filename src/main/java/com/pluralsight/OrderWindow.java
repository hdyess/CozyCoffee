package com.pluralsight;

public class OrderWindow extends Window{

	public OrderWindow(int width, int height) {
		super(width, height);
	}
	public void displayOrderWindow() {
		this.clearRows();
		this.printToNextRow( "Running total: " + WindowHandler.basket.getTotalPrice() );
		this.printToNextRow("Basket: ");
		for (Product p : WindowHandler.basket.getInBasket().values()) {
			this.printToNextRow(p.getName() + " - " + p.getTotalPrice());

			System.out.println(p);
			System.out.println(p.getTotalPrice());
			for (Option o : p.getAddedOptions()) {
				System.out.println(o.price);
			}
		}
	}

	public String runOrderWindowLogic()	{
		String[] choices = {"menu", "checkout", "exit"};
		return choices[ConsoleHelper.promptForInt("Input choice:")-1];
	}


}
