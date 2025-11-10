package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Basket {

	ArrayList<Item> inBasket;
	double basketPrice;


	public Basket() {
		this.basketPrice = 0;
		this.inBasket = new ArrayList<>();
	}


	public void addItem(Item item) {
		basketPrice += item.getPrice();
		inBasket.add(item);
	}

	public void removeItem(Item item) {
		basketPrice -= item.getPrice();
		inBasket.remove(item);
	}

	public double getTotalPrice() {
		return basketPrice;
	}

	public ArrayList<Item> getInBasket() {
		return inBasket;
	}



}
