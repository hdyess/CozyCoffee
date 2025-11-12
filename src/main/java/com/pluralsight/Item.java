package com.pluralsight;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Item {

	//fields
	String name;
	double basePrice;
	ArrayList<Item> availableOptions;
	LinkedHashMap<Item, Double> addedOptions;

	//constructor
	public Item(String name, Double basePrice) {
		this.name = name;
		this.basePrice = basePrice;
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
