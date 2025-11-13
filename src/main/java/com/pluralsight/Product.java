package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Product extends Item{

	ArrayList<Option> availableOptions;
	ArrayList<Option> addedOptions;
	double basePrice;
	int count;

	public Product(String name) {
		super(name);
		this.basePrice = 0.00;
	}

	public Product(String name, double basePrice) {
		super(name);
		this.basePrice = basePrice;
	}

	public void addAvailableOption(Option option) {
		availableOptions.add(option);
	}

	public void addOption(String name) {
		for (Option o : availableOptions) {
			if (o.getName().equalsIgnoreCase(name)) {
				availableOptions.add(o);
				break;
			}
		}
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void changeCount(int numberToChangeBy) {
		this.count += numberToChangeBy;
	}
	public double getTotalPrice() {
		double returnPrice = basePrice;
		if (!addedOptions.isEmpty()) {
			for(Option o : addedOptions) {
				returnPrice += o.getPrice();
			}
		}
		return returnPrice;
	}



}
