package com.pluralsight;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Item {

	//fields
	String name;
	double basePrice;
	LinkedHashMap<Item, Double> availableOptions;
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

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double BasePrice) {
		basePrice = BasePrice;
	}

	public void addOption(String itemName) {
		Item itemToAdd = Menu.getItem(itemName);
		this.addedOptions.putIfAbsent(itemToAdd, itemToAdd.getBasePrice());
	}

	public void removeOption(String itemName) {

	}

	public LinkedHashMap<Item, Double> getAvailableOptions() {
		return availableOptions;
	}

	public LinkedHashMap<Item, Double> getAddedOptions() {
		return addedOptions;
	}

	public double getTotalPrice() {
		if (addedOptions.isEmpty()) {
			return basePrice;
		}

		double returnPrice = basePrice;
		for (Item i : addedOptions.keySet()) {
				returnPrice += i.getTotalPrice();
		}

		return returnPrice;
	}

}//Item
