package com.pluralsight;

import java.util.ArrayList;

public class Window {

	private int width;
	private int height;
	private int orderX;
	private int orderY;
	private ArrayList<String> rows;

	public Window(int width, int height, int orderX, int orderY) {
		this.width = width;
		this.height = height;
		this.orderX = orderX;
		this.orderY = orderY;
		rows = new ArrayList<String>(height);
	}

	public ArrayList<String> getRows() {

		return rows;

	}

	public void printToNextRow(String lineToPrint) {
		if( (rows.getFirst().equalsIgnoreCase("")) || rows.getFirst()==null) {
			StringBuilder rowBuilder = new StringBuilder();
			rowBuilder.append("/");
			for (int i = 0; i < this.width-2; i++) {
				rowBuilder.append("-");
			}
			rowBuilder.append("\\");
			rows.add(rowBuilder.toString());
		}

		StringBuilder rowBuilder = new StringBuilder();
		rowBuilder.append("|");
		rowBuilder.append(lineToPrint);
		for (int i = 0; i < this.width-2; i++) {
			rowBuilder.append();
		}
		rowBuilder.append("|");
		rows.add(rowBuilder.toString());
	}




}
