package com.pluralsight;

public class Main {
	public static void main(String[] args) {

		Menu menu = new Menu();
		//loads menu with products from csv
		menu.initProducts();

		//handles all ui
		WindowHandler.initWindows();
		
	}
}
