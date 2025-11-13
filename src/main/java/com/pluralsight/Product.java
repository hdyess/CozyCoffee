package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Product extends Item{

	ArrayList<Option> options;
	double basePrice;

	public Product(String name) {
		super(name);
		this.basePrice = 0.00;
	}

	public Product(String name, double basePrice) {
		super(name);
		this.basePrice = basePrice;
	}

	public double getTotalPrice() {
		double returnPrice = basePrice;
		for(Option o : options) {
			returnPrice += o.getPrice(); 
		}
	}


}
