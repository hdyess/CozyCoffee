package com.pluralsight;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class CheckoutWindow extends Window{

	public CheckoutWindow(int width, int height) {
		super(width, height);
	}

	public void displayCheckoutWindow() {
		this.clearRows();
		this.printToNextRow("Have you finished your order?");
		this.printToNextRow("Current Order: ");
		StringBuilder optionsLineBuilder = new StringBuilder();
		for (Product p : WindowHandler.basket.getInBasket().values()) {
			this.printToNextRow(p.getName() + " - " + p.getTotalPrice());
			for(Option o : p.getAddedOptions()){
				optionsLineBuilder.append(o.name + " - " + o.getPrice());
			}
			this.printToNextRow(optionsLineBuilder.toString());
		}
		this.printToNextRow( "Total" + WindowHandler.basket.getTotalPrice() );

	}

	public void printReceipt()	{
		try {
			LocalDateTime time = LocalDateTime.now();
			StringBuilder title = new StringBuilder();
			title.append(time.getYear() + ":");
			title.append(time.getMonth() + ":");
			title.append(time.getDayOfMonth() + ":");
			title.append(time.getHour() + ":");
			title.append(time.getMinute() + ":");
			title.append(time.getSecond());
			String path = ConsoleHelper.promptForString("Enter path for receipt file: "); 


			File file = new File( path + title.toString() + ".txt");

			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter buffWriter = new BufferedWriter(fileWriter);


		} catch(Exception ex) {
			System.out.println(ex);
		}
	}




}
