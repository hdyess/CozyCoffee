package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Basket {

	private static ArrayList<Item> inBasket;


	public Basket() {
		this.inBasket = new ArrayList<>();
	}


	public void addItem(Item item) {
		inBasket.add(item);
	}

	public void removeItem(Item item) {
		inBasket.remove(item);
	}

	public double getTotalPrice() {
		double totalBasketPrice = 0.00;
		for (Item i : inBasket) {
			totalBasketPrice += i.getTotalPrice();
		}
		return totalBasketPrice;
	}

	public ArrayList<Item> getInBasket() {
		return inBasket;
	}



}
