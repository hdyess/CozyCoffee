package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Basket {

	LinkedHashMap<String, Product> inBasket;


	public Basket() {
		this.inBasket = new LinkedHashMap<>();
	}


	public void addProduct(Product product) {
		inBasket.put(product.getName(), product);
	}
	public void removeProduct(Product product) {
		inBasket.remove(product.getName(), product);
	}

	public LinkedHashMap<String, Product> getInBasket() {
		return inBasket;
	}

	public double getTotalPrice() {
		double totalBasketPrice = 0.00;
		for (Product i : inBasket.values()) {
			totalBasketPrice += i.getTotalPrice();
		}
		return totalBasketPrice;
	}


}
