package com.qa;

import com.qa.inserts.*;


import org.apache.log4j.Logger;

import com.qa.connections.Action;
import com.qa.connections.ChooseTable;
import com.qa.connections.RemoteJDBC;
import com.qa.dao.CustomerDataAccessObject;
import com.qa.dao.ItemAccessObject;
import com.qa.inserts.InsertItem;
import com.qa.schemas.Customer;
import com.qa.schemas.Item;
import com.qa.inserts.InsertItem;

public class Inv {
	
	public static final Logger LOGGER = Logger.getLogger(Inv.class);

	Input input = new Input();

	public void start() {

		System.out.println("Database username: ");
		String user = input.getInput();
		System.out.println("Database password: ");
		String password = input.getInput();

		RemoteJDBC connection = new RemoteJDBC(user, password);

		// ---- Actions for selecting INSERT, READ, UPDATE, DELETE ---- // 
		for (Action action : Action.values()) {
			System.out.println(action.name());
		}
		
		Action selectedChoice;
		String optionInput;
		while (true) {
			try {
				optionInput = input.getInput();
				selectedChoice = Action.valueOf(optionInput.toUpperCase());
				break;
			}

			catch (IllegalArgumentException e) {
				System.out.println("selection not valid, please re-enter: ");
			}
		}
		
		// --- End of Actions for selecting INSERT, READ, UPDATE, DELETE --- // 
		
 // ---- Menu Begins ---- //
		switch (selectedChoice) {
		case INSERT:
			System.out.println("Entering insert menu: ");
			System.out.println("Please select one of the following: ");
			
			for (ChooseTable chooseTable : ChooseTable.values()) {
				System.out.println(chooseTable.name());
			}
			
			
			break;
		default:
			break;
			
		}
		
		
		
		String chooseTableSelect;
		ChooseTable selectTable;
		while (true) {
			try {
				chooseTableSelect = input.getInput();
				selectTable = ChooseTable.valueOf(chooseTableSelect.toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("selection not valid, please re-enter: ");
				
			}
		}
		
		
		switch(selectTable) {
		
		case ITEM:
			System.out.println("--------------------");
			
			System.out.println("Item create: ");
			Input input = new Input();
			
				System.out.println("Please enter the name of your item: ");
				String item_name = input.getInput();
				
				System.out.println("Please enter the price: ");
				double price = input.getNumInput();
				
				System.out.println("Please type the category: ");
				String category = input.getInput();
				
				
				Item item = new Item(1, item_name, price, category);
				ItemAccessObject itemDao = new ItemAccessObject(connection);
				itemDao.insertAnItem(item);					
				System.out.println(item_name + " successfully added!");
				
				break;
				
		case CUSTOMER:
			
			Input input1 = new Input();
			
			System.out.println("customer first name:");
			String first_name = input1.getInput();

			System.out.println("customer last name:");
			String last_name = input1.getInput();

			System.out.println("customer address:");
			String address = input1.getInput();

			System.out.println("customer email:");
			String email = input1.getInput();

			System.out.println("customer password:");
			String sausage = input1.getInput();

			Customer customer = new Customer(1, first_name, last_name, address, email, sausage);

			CustomerDataAccessObject customerDao = new CustomerDataAccessObject(connection);
			customerDao.insertCutsomer(customer);
			System.out.println(customer.getFirst_name() + ", has been added to the database ");


			break;
			
		case ORDER:
			System.out.println("Orders menu");
			
			break;
			default:
			break;
				
		}
				

//		connection.closeConnection();
	}

}
