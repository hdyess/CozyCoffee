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
				optionsLineBuilder.append(o.name + " - " + o.getPrice() + "|");
			}
			this.printToNextRow(optionsLineBuilder.toString());
		}
		this.printToNextRow( "Total" + WindowHandler.basket.getTotalPrice() );

	}

	public void printReceipt()	{
		try {
			LocalDateTime time = LocalDateTime.now();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(time.getYear() + ":");
			stringBuilder.append(time.getMonthValue() + ":");
			stringBuilder.append(time.getDayOfMonth() + ":");
			stringBuilder.append(time.getHour() + ":");
			stringBuilder.append(time.getMinute() + ":");
			stringBuilder.append(time.getSecond());
			String path = ConsoleHelper.promptForString("Enter path for receipt file: ");

			File file = new File( path + stringBuilder.toString() + ".txt");
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter buffWriter = new BufferedWriter(fileWriter);

			buffWriter.write("<3~~~ Cozy Coffee Corner ~~~<3");
			buffWriter.newLine();
			buffWriter.write("Thank you for shopping!!!");
			buffWriter.newLine();
			buffWriter.newLine();

			for (Product p : WindowHandler.basket.getInBasket().values()) {
				stringBuilder = new StringBuilder();
				buffWriter.write(p.getName() + " - " + p.getTotalPrice());
				buffWriter.newLine();
				for(Option o : p.getAddedOptions()){
					stringBuilder.append(o.name + " - " + o.getPrice());
				}
				buffWriter.write(stringBuilder.toString());
				buffWriter.newLine();
				buffWriter.newLine();
				double subtotal = WindowHandler.basket.getTotalPrice();
				buffWriter.write("Subtotal: " + subtotal);
				buffWriter.newLine();
				buffWriter.write( String.format("Total: %.2f", subtotal*1.07 ) );
				buffWriter.close();
			}



		} catch(Exception ex) {
			System.out.println(ex);
		}
	}




}
