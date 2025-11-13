package com.pluralsight;

public class Option extends Item{

	double price;
	String category;
	boolean required;
	boolean numberable;
	int count;

	public Option(String name, double price, String category, boolean numberable, boolean required) {
		super(name);
		this.price = price;
		this.category = category;
		this.numberable = numberable;
		this.count = 0;
		this.required = required;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public boolean isNumberable() {
		return numberable;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void changeCount(int numberToChangeBy) {
		count += numberToChangeBy;
	}
}
