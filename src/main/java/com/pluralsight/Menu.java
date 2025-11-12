package com.pluralsight;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Menu {


	/*
	Currently building menu such that everything is an item, and every
	different priced option requires a unique option for that item.

	EX: latteSize8 and latteSize 12 for different prices of 8 and 12 oz latte

	Items are defined based on allItems.csv
	Item relationships are defined based on menuItems.csv

	This sucks because it means I have to manually write these items for every
	different price for every option.
	It'd be best to have actual logic determining price, based on a csv,
	rather than just using a specific option item that has the right price.
	Maybe logic could be totally separate from the items, IE items wouldn't store
	their price, the menu would determine the correct price based on the combo
	of option items included in a single item.
	I will do this if I have time.
	*/


	//full item directory
	private static ArrayList<Item> allItems;
	//menu as it is shown to the user, with items containing option items
	private static ArrayList<Item> menuItems;


	public static Item getItem(String itemName) {
		for (Item i : allItems) {
			if (i.getName().equalsIgnoreCase(itemName)) {
				return i;
			}
		}
		return null;
	}

	public static void addToAllItems(Item item) {
		allItems.add(item);
	}



}
