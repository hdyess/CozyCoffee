package com.pluralsight;

import java.util.ArrayList;

public class WindowHandler {


	//0 encapsulation here, some can probably be fixed
	private static int topRowHeight = 22;

	private static Product productChoice;

	public static Basket basket = new Basket();

	public static ArrayList<Window> topWinRow = new ArrayList<>();
	public static ArrayList<Window> bottomWinRow = new ArrayList<>();

	public static HomeWindow homeWindow = new HomeWindow(60, topRowHeight);
	public static MenuWindow menuWindow = new MenuWindow(60, topRowHeight);
	public static AddToBasketWindow addToBasketWindow = new AddToBasketWindow(60, topRowHeight);
	public static CheckoutWindow checkoutWindow = new CheckoutWindow(60, topRowHeight);

	public static OrderWindow orderWindow = new OrderWindow(50, topRowHeight);
	public static Window musicWindow = new Window(90, 2);

	public static String nextWindowName = "home";

	public static void displayWindows(ArrayList<Window> winRow) {

		ArrayList<ArrayList<String>> rows = new ArrayList<>();
		int lines = 0;
		for(Window w : winRow) {
			if(w.getHeight() > lines) {
				lines = w.getHeight();
			}
			rows.add(w.getRows());
		}
		lines +=1;
		for (int i = 0; i < lines; i++) {
			for(ArrayList<String> a : rows) {
				System.out.print(a.get(i));
			}
			System.out.print("\n");
		}


		/*
		ArrayList<StringBuilder> fullDisplayLinesToPrint = new ArrayList<>();

		for (int i = 0; i < winRow.getFirst().getHeight()+1; i++) {
			fullDisplayLines.add(new StringBuilder());
		}

		for (Window w : winRow) {
			ArrayList<String> rowsToPrint = w.getRows();

			if (fullDisplayLinesToPrint.isEmpty()) {
				for (int i = 0; i < rowsToPrint.size(); i++) {
					fullDisplayLinesToPrint.add(new StringBuilder().append(rowsToPrint.get(i)));
				}
			} else {
				for (int i = 0; i < rowsToPrint.size(); i++) {
					fullDisplayLinesToPrint.get(i).append(rowsToPrint.get(i));
				}
			}
//			if (fullDisplayLinesToPrint.isEmpty()) {
//				fullDisplayLinesToPrint = new ArrayList<>(rowsToPrint.size());
//				for (int i = 0; i < rowsToPrint.size(); i++) {
//					fullDisplayLinesToPrint.add(new StringBuilder());
//				}
//			}
//
//			for (int i = 0; i < rowsToPrint.size(); i++) {
//				fullDisplayLinesToPrint.get(i).append(rowsToPrint.get(i));
//			}

		}

		fullDisplayLinesToPrint.forEach(stringBuilder -> System.out.println(stringBuilder.toString()));
		fullDisplayLinesToPrint.clear();

		*/
	}


	public static void initWindows() {

		musicWindow.printToNextRow("Now playing: " + Main.musicPath);


		while (nextWindowName != "exit") {
			ConsoleHelper.consoleClear();
			switch (nextWindowName) {
				case "home":
					orderWindow.displayOrderWindow();
					homeWindow.displayHomeWindow();

					topWinRow = new ArrayList<>();
					bottomWinRow = new ArrayList<>();
					topWinRow.add(homeWindow);
					topWinRow.add(orderWindow);
					bottomWinRow.add(musicWindow);

					displayWindows(topWinRow);
					displayWindows(bottomWinRow);

					nextWindowName = homeWindow.runHomeLogic();
					ConsoleHelper.consoleClear();
					break;
				case "menu":
					menuWindow.displayMenuWindow();
					orderWindow.displayOrderWindow();


					topWinRow = new ArrayList<>();
					bottomWinRow = new ArrayList<>();

					topWinRow.add(menuWindow);
					topWinRow.add(orderWindow);
					bottomWinRow.add(musicWindow);

					displayWindows(topWinRow);
					displayWindows(bottomWinRow);

					String choice = menuWindow.runMenuLogic();

					for(String s : MenuWindow.menu.getProductMap().keySet()) {
						if(choice.equalsIgnoreCase(s)) {
							productChoice = MenuWindow.menu.getProduct(s);
							nextWindowName = "addToBasket";
							System.out.println(productChoice.getName());
							break;
						}
					}

					if(!nextWindowName.equalsIgnoreCase("addToBasket")) {
						nextWindowName = "home";
						break;
					}
					ConsoleHelper.consoleClear();
					break;
				case "addToBasket":
					addToBasketWindow.displayAddToBasketWindow(productChoice);
					orderWindow.displayOrderWindow();

					topWinRow = new ArrayList<>();
					bottomWinRow = new ArrayList<>();

					topWinRow.add(addToBasketWindow);
					topWinRow.add(orderWindow);
					bottomWinRow.add(musicWindow);

					displayWindows(topWinRow);
					displayWindows(bottomWinRow);

					addToBasketWindow.runAddToBasketWindowLogic(productChoice);

					ConsoleHelper.consoleClear();

					displayWindows(topWinRow);
					displayWindows(bottomWinRow);

					ConsoleHelper.promptForString("");

					nextWindowName = "menu";
					break;
				case "checkout":
					checkoutWindow.displayCheckoutWindow();
					orderWindow.displayCheckoutInfo();

					topWinRow = new ArrayList<>();
					bottomWinRow = new ArrayList<>();

					topWinRow.add(checkoutWindow);
					topWinRow.add(orderWindow);
					bottomWinRow.add(musicWindow);

					displayWindows(topWinRow);
					displayWindows(bottomWinRow);

					int checkoutChoice = ConsoleHelper.promptForInt("Input choice: ");

					switch (checkoutChoice) {
						case 1:
							checkoutWindow.printReceipt();
							orderWindow.clearRows();

							topWinRow = new ArrayList<>();
							bottomWinRow = new ArrayList<>();

							topWinRow.add(checkoutWindow);
							topWinRow.add(orderWindow);
							bottomWinRow.add(musicWindow);

							displayWindows(topWinRow);
							displayWindows(bottomWinRow);

							basket = new Basket();
							break;
						case 2:
							basket = new Basket();
							break;
						case 3:
							break;
					}

					nextWindowName = "home";
					break;
				default:
					nextWindowName = "home";
					break;
			}

		}


	}



	/*
	public ArrayList<Window> getTopWinRow() {
		return topWinRow;
	}
	public void addTopWindow(Window window) {
		topWinRow.add(window);
	}
	public void removeTopWindow(int orderOfWindow) {
		topWinRow.remove(orderOfWindow);
	}

	public ArrayList<Window> getBottomWinRow() {
		return bottomWinRow;
	}
	public void addBottomWindow(Window window) {
		bottomWinRow.add(window);
	}
	public void removeBottomWindow(int orderOfWindow) {
		bottomWinRow.remove(orderOfWindow);
	}
	*/





}
