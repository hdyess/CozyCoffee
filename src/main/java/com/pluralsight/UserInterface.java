package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserInterface {



	private static ArrayList<Window> topWinRow = new ArrayList<>();
	private static ArrayList<Window> bottomWinRow = new ArrayList<>();


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

	public static ArrayList<Window> getTopWinRow() {
		return topWinRow;
	}
	public static void addTopWindow(Window window) {
		topWinRow.add(window);
	}
	public static void removeTopWindow(int orderOfWindow) {
		topWinRow.remove(orderOfWindow);
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
