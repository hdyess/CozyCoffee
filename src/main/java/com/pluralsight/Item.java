package com.pluralsight;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Item {

	//fields
	String name;
	double basePrice;
	ArrayList<Item> availableOptions;
	ArrayList<Item> addedOptions;

	//constructors
	public Item(String name) {
		this.name = name;
		this.basePrice = 0.00;
		this.availableOptions = new ArrayList<>();
		this.addedOptions = new ArrayList<>();
	}

	public Item(String name, Double basePrice) {
		this.name = name;
		this.basePrice = basePrice;
	}

	//methods
	public String getName() {
		return name;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double BasePrice) {
		basePrice = BasePrice;
	}

	public void addOption(String itemName) {

	}

	public void removeOption(String itemName) {

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
