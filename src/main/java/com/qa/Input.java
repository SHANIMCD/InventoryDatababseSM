package com.qa;

import java.util.Scanner;

public class Input {

	private Scanner scanner = new Scanner(System.in);

	public String getInput() {
		return scanner.nextLine();
	}

	public double getNumInput() {

		double value;

		while (true) {
			try {

				value = Double.parseDouble(scanner.nextLine());
				return value;
			} catch (NumberFormatException exc) {
				exc.printStackTrace();
			}
		}

	}

	public int getIntInput() {

		int value;

		while (true) {
			try {

				value = Integer.parseInt(scanner.nextLine());
				return value;
			} catch (NumberFormatException exc) {
				exc.printStackTrace();
			}
		}

	}
}
