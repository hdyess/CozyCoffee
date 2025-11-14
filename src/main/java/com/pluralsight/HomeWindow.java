package com.pluralsight;

public class HomeWindow extends Window {




	public HomeWindow(int width, int height) {
		super(width, height);
	}
	public void displayHomeWindow() {
		this.printToNextRow("<3~~~ Welcome to the Cozy Coffee Corner ~~~<3");
		this.printToNextRow(String.format("1. View Menu"));
		this.printToNextRow(String.format("2. Checkout"));
		this.printToNextRow(String.format("3. Exit POS"));
	}

	public String runHomeLogic()	{
		String[] choices = {"menu", "checkout", "exit"};
		return choices[ConsoleHelper.promptForInt("Input choice:")-1];
	}







}
