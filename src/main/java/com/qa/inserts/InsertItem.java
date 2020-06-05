package com.qa.inserts;
import java.util.Scanner;
import com.qa.connections.RemoteJDBC;
import com.qa.Input;
import com.qa.dao.ItemAccessObject;
import com.qa.schemas.Item;

public class InsertItem {
	
	Input input = new Input();

	public void ItemMenu() {
		System.out.println("Please enter the name of your item: ");
		String item_name = input.getInput();
		
		System.out.println("Please enter the price: ");
		double price = input.getNumInput();
		
		System.out.println("Please type the category: ");
		String category = input.getInput();
		
		Item item = new Item(1, item_name, price, category);
		
		System.out.println(item_name + " successfully added!");
		
	}

}
