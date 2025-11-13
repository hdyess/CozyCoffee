package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Product extends Item{

	private ArrayList<Option> availableOptions;
	private ArrayList<Option> addedOptions;
	private double basePrice;
	private int count;


	public Product(String name) {
		super(name);
		this.basePrice = 0.00;
		this.count=1;
		this.availableOptions = new ArrayList<>();
		this.addedOptions = new ArrayList<>();
	}

	public Product(String name, double basePrice) {
		super(name);
		this.basePrice = basePrice;
		this.count=1;
		this.availableOptions = new ArrayList<>();
		this.addedOptions = new ArrayList<>();
	}


	public ArrayList<Option> getAvailableOptions() {
		return availableOptions;
	}
	public void addAvailableOption(Option option) {
		availableOptions.add(option);
	}

	public ArrayList<Option> getAddedOptions() {
		return addedOptions;
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
