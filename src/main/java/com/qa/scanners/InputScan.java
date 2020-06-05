package com.qa.scanners;

import java.util.Scanner;

public class InputScan {

	private static Scanner scan = new Scanner(System.in);
	
	public String getString() {
		return scan.nextLine();
	}
	
	public int getNumber() {
		int value;
		
		while (true) {
			System.out.println("Enter number: ");
			value = Integer.parseInt(scan.nextLine());
			return value;
		}
	}
}
