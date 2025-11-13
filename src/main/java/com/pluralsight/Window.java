package com.pluralsight;

import java.util.ArrayList;

public class Window {

	private int width;
	private int height;
	private ArrayList<String> rows;

	public Window(int width, int height) {
		this.width = width;
		this.height = height;
		this.rows = new ArrayList<String>();
	}


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<String> getRows() {


		if(rows.size()<this.height) {
			printToNextRow(" ");
			int heightDifference = this.height - rows.size();
			for (int i = 0; i < heightDifference; i++) {
				printToNextRow(" ");
			}
		}

		addBottomCap();
		//returns all rows
		return rows;
	}

	public void printToNextRow(String stringToPrint) {
		if(rows.isEmpty()) {
			addTopCap();
		}

		addCenterLine(stringToPrint);

	}

	public void addTopCap() {
		StringBuilder rowBuilder = new StringBuilder();
		rowBuilder.append("/");
		rowBuilder.append("-".repeat(this.width-2));
		rowBuilder.append("\\");
		rows.add(rowBuilder.toString());
	}

	public void addBottomCap() {
		StringBuilder rowBuilder = new StringBuilder();
		rowBuilder.append("\\");
		rowBuilder.append("-".repeat(this.width-2));
		rowBuilder.append("/");
		rows.add(rowBuilder.toString());
	}

	public void addCenterLine(String lineText) {
		StringBuilder rowBuilder = new StringBuilder();
		rowBuilder.append("|");
		rowBuilder.append(lineText);
		if (rowBuilder.length()<this.width-1) {
			rowBuilder.append(" ".repeat(this.width-1-rowBuilder.length()));
		}
		rowBuilder.append("|");
		rows.add(rowBuilder.toString());
	}



	public void clearRows() {
		this.rows = new ArrayList<String>(0);
	}




}
