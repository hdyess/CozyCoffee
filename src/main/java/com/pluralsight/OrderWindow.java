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
			for (Option o : p.getAddedOptions()) {
				System.out.println(o.price);
			}
		}
	}

	public void displayCheckoutInfo() {
		this.clearRows();
		this.printToNextRow("1. Complete checkout, print receipt.");
		this.printToNextRow("2. Complete checkout, no receipt.");
		this.printToNextRow("3. Return home.");
	}



}
