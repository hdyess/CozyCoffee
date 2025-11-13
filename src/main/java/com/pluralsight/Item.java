package com.pluralsight;

public abstract class Item {

	String name;

	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	//this is basically the whole class before rewrite
	/*
//	public Item(String name, Double basePrice) {
//		this.name = name;
//		this.basePrice = basePrice;
//		this.availableOptions = new LinkedHashMap<>();
//		this.addedOptions = new LinkedHashMap<>();

//	}
//	LinkedHashMap<String, Item> availableOptions;
//	LinkedHashMap<String, Item> addedOptions;



	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double BasePrice) {
		basePrice = BasePrice;
	}

	public void addAvailableOption(String itemName) {
		availableOptions.putIfAbsent(itemName, Menu.getFromMenu(itemName));
		availableOptions.putIfAbsent(itemName, Menu.getFromAll(itemName));
		if (availableOptions.get(itemName) == null) {
			availableOptions.put(itemName, new Item(itemName));
		}
	}
	public void removeAvailableOption(String itemName) {
		availableOptions.remove(itemName);

		//		for (String n : availableOptions.keySet()) {
//			if (n.equalsIgnoreCase(itemName)) {
//				availableOptions.remove(itemName);
//				break;
//			}
//		}
	}

	public void addOption(String itemName) {
		 if (availableOptions.containsKey(itemName)) {
			 addedOptions.putIfAbsent(itemName, availableOptions.get(itemName));
		 }
	}
	public void removeOption(String itemName) {
		addedOptions.remove(itemName);
	}

	public LinkedHashMap<String, Item> getAvailableOptions() {
		return availableOptions;
	}
	public LinkedHashMap<String, Item> getAddedOptions() {
		return addedOptions;
	}

	public double getTotalPrice() {
		if (addedOptions.isEmpty()) {
			return basePrice;
		}

		double returnPrice = basePrice;
		for (Item i : addedOptions.values()) {
				returnPrice += i.getTotalPrice();
		}

		return returnPrice;
	}
*/

}//Item
