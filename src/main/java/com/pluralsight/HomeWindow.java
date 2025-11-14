package com.pluralsight;

import java.util.ArrayList;

public class HomeWindow extends Window {




	public HomeWindow(int width, int height) {
		super(width, height);
	}
	public void displayHome() {
		this.printToNextRow("Welcome to the Cozy Coffee Corner");
		this.printToNextRow(String.format("1. View Menu"));
		this.printToNextRow(String.format("2. Checkout"));
		this.printToNextRow(String.format("3. Exit POS"));
	}

	public String runHomePrompt()	{
		String[] choices = {"menu", "checkout", "exit"};
		return choices[ConsoleHelper.promptForInt("Input choice:")-1];
	}







}
