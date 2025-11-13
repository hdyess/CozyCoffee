package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserInterface {

	private static ArrayList<Window> winRow1;
	private static ArrayList<Window> winRow2;

	//for now everything assumes windows within a row are of equal height
	public static void displayWindows() {
		ArrayList<StringBuilder> fullDisplayLines = new ArrayList<>();
		for (Window w : winRow1) {

		}

		fullDisplayLines.forEach(stringBuilder -> System.out.println(stringBuilder.toString()));

	}





}
