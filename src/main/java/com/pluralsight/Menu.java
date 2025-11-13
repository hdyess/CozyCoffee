package com.pluralsight;

import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Menu {

	ArrayList<Product> menuItems;

	//this is all hard coded and that's basically what I was trying to avoid
	//before rewriting everything
	public void initProducts() {
		LinkedHashMap<String, Product> returnList = new LinkedHashMap();
		//this is the worst code ever written
		//i hope a future employer doesn't see this
		returnList.put("latte", new Product("latte"));
		returnList.get("latte").addAvailableOption(new Option("8oz", 4.99, "milk", false, true, true));
		returnList.get("latte").addAvailableOption(new Option("12oz", 5.99, "milk", false, true, true));
		returnList.get("latte").addAvailableOption(new Option("16oz", 5.99, "milk", false, true, true));
		returnList.get("latte").addAvailableOption(new Option("hot", 0.00, "temp", false, true, true ));
		returnList.get("latte").addAvailableOption(new Option("cold", 0.00, "temp", false, true, true));
		returnList.get("latte").addAvailableOption(new Option("whole", 0.00, "milkType", false, true, true));
		returnList.get("latte").addAvailableOption(new Option("oat", 0.00, "milkType", false, true, true));
		returnList.get("latte").addAvailableOption(new Option("almond", 0.25, "milkType", false, true, true));
		returnList.get("latte").addAvailableOption(new Option("whole", 0.00, "milkType", false, true, true));
		

	}

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

	/*
	update:
	This is so catastrophic i'm going to have to handle this previous todo.
	Things just become 1000x times simpler if I can just define the
	different options for an item and then define the prices some other way.
	I don't even know how yet it just has to happen cause this is otherwise
	impossible to think through and make clean.
	I should have just coded this worse and given myself more time.
	Only one way to learn I guess.
	*/

/*
	//full item directory
	private static LinkedHashMap<String, Item> allItems = new LinkedHashMap<>();
	//menu as it is shown to the user, with items containing option items
	private static LinkedHashMap<String, Item> menuItems = new LinkedHashMap<>();

	public static LinkedHashMap<String, Item> getAllItems() {
		return allItems;
	}
	public static void addToAllItems(Item item) {
		allItems.put(item.getName(), item);
	}

	public static LinkedHashMap<String, Item> getMenuItems() {
		return menuItems;
	}
	public static void addToMenuItems(Item item) {
		menuItems.put(item.getName(), item);
	}

	public static Item getFromAll(String itemName) {
		return allItems.get(itemName);

//		try {
//		} catch (Exception ex) {
//			System.out.println(ex);
//			//todo: bad behavior if allItems is empty?
//			return allItems.firstEntry().getValue();
//		}

//		for (String n : allItems.keySet()) {
//			if (n.equalsIgnoreCase(itemName)) {
//				return allItems.get(itemName);
//			}
//		}
//		return allItems.firstEntry().getValue();
	}
	public static Item getFromMenu(String itemName) {
		return menuItems.get(itemName);
	}

*/



}
