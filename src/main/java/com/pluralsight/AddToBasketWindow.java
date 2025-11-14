package com.pluralsight;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AddToBasketWindow extends Window{


	public AddToBasketWindow(int width, int height) {
		super(width, height);
	}
	public void displayAddToBasketWindow(Product product) {
		this.clearRows();

		for (String s : product.toString().split("\\|")) {
			this.printToNextRow(s);
		}


	}

	public String runAddToBasketWindowLogic(Product product) {

		String[] choices = ConsoleHelper.promptForString("Input the options you want for your item: ").split("\\|");
		ArrayList<String> categories = new ArrayList<>();
		ArrayList<String> errorText = new ArrayList<>();
		String size = "5oz";

		try {
			Arrays.stream(choices).forEach(System.out::println);
			for (Option o : product.getAvailableOptions()) {
				System.out.println(o.getName() + o.getCategory());
			}
			for(String s : choices) {
				product.addOption(s);
			}
//			System.out.println("Cats:");
//			for(Option o : product.getAddedOptions()){
//
//				System.out.println();
//			}
			//this all verifies item for addition to basket
			for(Option o : product.getAddedOptions()) {
//				System.out.println(categories.contains(o.getCategory()));
				if (o.isExclusive() && categories.contains(o.getCategory())){
					errorText.add("Can only have one product of category: " + o.getCategory() + ". ");
				}
//				System.out.println(o.getCategory());
//				System.out.println("gamer");
				categories.add(o.getCategory());
			}
			System.out.println(categories);
			for(Option o : product.getAddedOptions()) {
				//yes i know it says numberable and not numerable
				if (o.isNumberable()) {
					o.setCount(ConsoleHelper.promptForInt("How many " + o.getName() + " do you want to add?"));
				} else {
					o.setCount(1);
				}
				if (o.getCategory().equalsIgnoreCase("size")) {
					size = o.getName();
				}
			}
//			System.out.println("Categories: ");
//			for (String s : categories) {
//				System.out.println(s);
//			}
			for(Option o : product.getAvailableOptions()) {
				if(o.isRequired()&&!categories.contains(o.getCategory())) {
					errorText.add("Must have at least one product of category: " + o.getCategory() + ". ");
				}
			}

			//sets milk price according to size
			//this is really bad but im not making it better right now
			//not that it matters too much since this is only run when adding a product
			if (Arrays.asList(choices).contains("oat")) {
				HashMap<String, Double> oatPrices = new HashMap<>();
				oatPrices.put("5oz", 0.00);
				oatPrices.put("8oz", 0.25);
				oatPrices.put("12oz", 0.5);
				oatPrices.put("16oz", 0.75);
				for(Option o : product.getAddedOptions()) {
					if(o.getName().equalsIgnoreCase("oat")) {
						o.setPrice(oatPrices.get(size));
					}
				}
			} else if (Arrays.asList(choices).contains("almond")) {
				HashMap<String, Double> almondPrices = new HashMap<>();
				almondPrices.put("5oz", 0.25);
				almondPrices.put("8oz", 0.50);
				almondPrices.put("12oz", 0.75);
				almondPrices.put("16oz", 1.00);
				for(Option o : product.getAddedOptions()) {
					if(o.getName().equalsIgnoreCase("almond")) {
						o.setPrice(almondPrices.get(size));
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
			this.clearRows();
			this.printToNextRow("Error occurred while adding item, press enter to continue.");

		}
		if(errorText.isEmpty()) {
			WindowHandler.basket.inBasket.put(product.getName(), product);
			//WindowHandler.basket.addProduct(product);
			this.clearRows();
			this.printToNextRow("Item added successfully, press enter to continue.");
			return "menu";
		}

		this.clearRows();
		for(String s : errorText ) {
			this.printToNextRow(s);
		}
		return "menu";
	}

}
