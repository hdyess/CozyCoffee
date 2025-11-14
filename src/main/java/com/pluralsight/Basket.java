package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Basket {

	public LinkedHashMap<String, Product> inBasket;


	public Basket() {
		this.inBasket = new LinkedHashMap<>();
	}


	public void addProduct(Product product) {
		this.inBasket.put(product.getName(), product);
	}
	public void removeProduct(Product product) {
		this.inBasket.remove(product.getName(), product);
	}

	public LinkedHashMap<String, Product> getInBasket() {
		return this.inBasket;
	}

	public double getTotalPrice() {
		double totalBasketPrice = 0.00;
		for (Product i : inBasket.values()) {
			totalBasketPrice += i.getTotalPrice();
		}
		return totalBasketPrice;
	}


}
