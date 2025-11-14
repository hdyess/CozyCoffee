package com.pluralsight;

import java.util.ArrayList;

public class WindowHandler {

	private static Product productChoice;

	public static ArrayList<Window> topWinRow = new ArrayList<>();
	public static ArrayList<Window> bottomWinRow = new ArrayList<>();

	public static HomeWindow homeWindow = new HomeWindow(70, 20);
	public static MenuWindow menuWindow = new MenuWindow(70, 20);

	public static Window orderWindow = new Window(50, 20);
	public static Window musicWindow = new Window(120, 2);

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
		while (nextWindowName != "exit") {
			ConsoleHelper.consoleClear();
			switch (nextWindowName) {
				case "home":
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
							break;
						}
					}
					nextWindowName = "home";
					ConsoleHelper.consoleClear();
					break;
				case "addToBasket":
								





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
