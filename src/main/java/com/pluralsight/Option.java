package com.pluralsight;

public class Option extends Item{

	double price;
	String category;
	boolean required;
	boolean numberable;
	int count;
	boolean exclusive;

	public Option(String name, double price, String category, boolean numerable, boolean required, boolean exclusive) {
		super(name);
		this.price = price;
		this.category = category;
		this.numberable = numerable;
		this.count = 0;
		this.required = required;
		this.exclusive = exclusive;
	}

	public double getPrice() {
		return price*count;
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
		if (!isNumberable()&&count>1) {
		this.count = 1;
		return;
		}
		this.count = count;
	}

	public void changeCount(int numberToChangeBy) {
		if (!isNumberable()&&this.count+numberToChangeBy>1) {
			this.count = 1;
			return;
		}
		this.count += numberToChangeBy;
	}
}
