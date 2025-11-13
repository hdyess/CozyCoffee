package com.pluralsight;

import java.util.ArrayList;

public class UserInterface {

	public static ArrayList<Window> topWinRow = new ArrayList<>();
	public static ArrayList<Window> bottomWinRow = new ArrayList<>();

	//for now everything assumes windows within a row are of equal height
	//I feel like there's some sorta table data structure that I could use here but i am
	//too lazy and pressed for time to figure it out
	public static void displayWindows(ArrayList<Window> winRow) {
		ArrayList<StringBuilder> fullDisplayLinesToPrint = new ArrayList<>();
		/*
		for (int i = 0; i < winRow.getFirst().getHeight()+1; i++) {
			fullDisplayLines.add(new StringBuilder());
		}
		*/
		for (Window w : winRow) {
			ArrayList<String> rowsToPrint = w.getRows();

			if (fullDisplayLinesToPrint.isEmpty()) {
				fullDisplayLinesToPrint = new ArrayList<>(rowsToPrint.size());
				for (int i = 0; i < rowsToPrint.size(); i++) {
					fullDisplayLinesToPrint.add(new StringBuilder());
				}
			}

			for (int i = 0; i < rowsToPrint.size(); i++) {
//				if (fullDisplayLinesToPrint.get(i).isEmpty()) {
//					fullDisplayLinesToPrint.add( new StringBuilder().append(rowsToPrint.get(i)) );
//				}
				fullDisplayLinesToPrint.get(i).append(rowsToPrint.get(i));
			}

		}

		fullDisplayLinesToPrint.forEach(stringBuilder -> System.out.println(stringBuilder.toString()));

	}

	public static ArrayList<Window> getTopWinRow() {
		return topWinRow;
	}
	public static void addTopWindow(Window window) {
		topWinRow.add(window);
	}
	public static void removeTopWindow(int orderOfWindow) {
		topWinRow.remove(orderOfWindow);
	}

	public static void displayTopRow() {
		ArrayList<StringBuilder> fullDisplayLines = new ArrayList<>();
		for (int i = 0; i < topWinRow.getFirst().getHeight(); i++) {
			fullDisplayLines.add(new StringBuilder());
		}
		for (Window w : topWinRow) {
			ArrayList<String> winRows = w.getRows();
			for (int i = 0; i < w.getHeight(); i++) {
				fullDisplayLines.get(i).append(winRows.get(i));
			}
		}
		fullDisplayLines.forEach(stringBuilder -> System.out.println(stringBuilder.toString()));
	}


	public static ArrayList<Window> getBottomWinRow() {
		return bottomWinRow;
	}
	public static void addBottomWindow(Window window) {
		bottomWinRow.add(window);
	}
	public static void removeBottomWindow(int orderOfWindow) {
		bottomWinRow.remove(orderOfWindow);
	}



}
