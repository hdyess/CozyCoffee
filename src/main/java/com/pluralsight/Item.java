package com.pluralsight;

import java.util.ArrayList;

public class Item {

	//fields
	String name;
	double basePrice;
	ArrayList<Item> availableOptions;
	ArrayList<Item> addedOptions;
	boolean priceChanges;

	//constructor
	public Item(String name, Double basePrice, boolean priceChanges) {
		this.name = name;
		this.basePrice = basePrice;
		this.priceChanges = priceChanges;
	}

	//methods
	public String getName() {
		return name;
	}

	public void setBasePrice(double BasePrice) {
		basePrice = BasePrice;
	}

	public ArrayList<Item> getAvailableOptions() {
		return availableOptions;
	}

	public ArrayList<Item> getAddedOptions() {
		return addedOptions;
	}

	public double getTotalPrice() {
		if (addedOptions.isEmpty()) {
			return basePrice;
		}

		double returnPrice = basePrice;
		for (Item i : addedOptions) {
				returnPrice += i.getTotalPrice();
		}
		return returnPrice;
	}

}//Item
