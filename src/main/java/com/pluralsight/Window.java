package com.pluralsight;

import java.util.ArrayList;

public class Window {

	private int width;
	private int height;
	private ArrayList<String> rows;
	StringBuilder rowBuilder;

	public Window(int width, int height) {
		this.width = width;
		this.height = height;
		rows = new ArrayList<String>();
		this.rowBuilder = new StringBuilder();
	}


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<String> getRows() {
		if(rows.size()<this.height) {
			for (int i = 0; i < this.height-2; i++) {
				printToNextRow("");
			}
		}

		//adds ending row
		rowBuilder = new StringBuilder();
		rowBuilder.append("\\");
		rowBuilder.append("-".repeat(this.width-2));
		rowBuilder.append("/");
		rows.add(rowBuilder.toString());
		//returns all rows
		return rows;

	}

	public void printToNextRow(String stringToPrint) {
		if(rows.isEmpty()) {
			rowBuilder = new StringBuilder();
			rowBuilder.append("/");
			rowBuilder.append("-".repeat(this.width-2));
			rowBuilder.append("\\");
			rows.add(rowBuilder.toString());
		}


		rowBuilder = new StringBuilder();
		rowBuilder.append("|");
		rowBuilder.append(stringToPrint);
		if (rowBuilder.length()<this.width-1) {
			rowBuilder.append(" ".repeat(this.width-1-rowBuilder.length()));
		}
		rowBuilder.append("|");
		rows.add(rowBuilder.toString());
	}

	public void clearRows() {
		this.rows = new ArrayList<>();
	}




}
