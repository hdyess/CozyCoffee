package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Basket {

	private ArrayList<Product> inBasket;


	public Basket() {
		this.inBasket = new ArrayList<>();
	}


	public void addProduct(Product product) {
		inBasket.add(product);
	}

	public void removeProduct(Product product) {
		inBasket.remove(product);
	}

	public double getTotalPrice() {
		double totalBasketPrice = 0.00;
		for (Product i : inBasket) {
			totalBasketPrice += i.getTotalPrice();
		}
		return totalBasketPrice;
	}

	public ArrayList<Product> getInBasket() {
		return inBasket;
	}


}
