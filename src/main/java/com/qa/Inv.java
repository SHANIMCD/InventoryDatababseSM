package com.qa;

import org.apache.log4j.Logger;
import com.qa.connections.Action;
import com.qa.connections.ChooseTable;
import com.qa.connections.RemoteJDBC;
import com.qa.dao.CustomerDataAccessObject;
import com.qa.dao.ItemAccessObject;
import com.qa.dao.OrderDataAccessObject;
import com.qa.dao.OrderlineDataAccessObject;
import com.qa.schemas.Customer;
import com.qa.schemas.Item;
import com.qa.schemas.Order;
import com.qa.schemas.Orderline;


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

			switch (selectTable) {

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

				System.out.println("------");

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
				customerDao.insertCustomer(customer);
				System.out.println(customer.getFirst_name() + ", has been added to the database ");

				break;
				
			case ORDERLINE:
				Input input3 = new Input();
				System.out.println("Orderline create: ");
				System.out.println("Enter order ID: ");
				int order_id_fk = input3.getIntInput();
				System.out.println("Enter Item ID: ");
				int _item_id_fk = input3.getIntInput();
				System.out.println("Enter Item quantity: ");
				int QTY = input3.getIntInput();
				
				Orderline orderline = new Orderline(0, order_id_fk, _item_id_fk, QTY);
				OrderlineDataAccessObject orderlineDao = new OrderlineDataAccessObject(connection);
				orderlineDao.insertIntoORderline(orderline);
				
				System.out.println("Order successfully added");
				
				break;

			case ORDER:
				Input input2 = new Input();
				System.out.println("Order create: ");
				System.out.println("Enter Customer ID: ");
				int cust_id_fk = input2.getIntInput();
				System.out.println("Enter Item ID: ");
				int item_id_fk = input2.getIntInput();

				Order order = new Order(1, cust_id_fk, item_id_fk, null);

				OrderDataAccessObject orderDao = new OrderDataAccessObject(connection);

				orderDao.insertAnOrder(order);
				System.out.println(" Successfully added into orderline");

				break;
			default:
				connection.closeConnection();

			}
			
			break;

		case READ:
			System.out.println("Entering READ menu: ");
			System.out.println("Please select one of the following: ");

			for (ChooseTable chooseTableRead : ChooseTable.values()) {
				System.out.println(chooseTableRead.name());
			}

			String selectedToRead;
			ChooseTable chooseTableRead;

			while (true) {
				try {
					selectedToRead = input.getInput();
					chooseTableRead = ChooseTable.valueOf(selectedToRead.toUpperCase());
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("selection not valid, please re-enter: ");

				}
			}

			switch (chooseTableRead) {

			case ITEM:
				System.out.println("Entering Read item: ");
				
				int item_id;
				String item_name;
				double price;
				String category;
				
				
//				Item item = new Item(item_id, item_name, price, category);
				ItemAccessObject itemDao = new ItemAccessObject(connection);
				
//				itemDao.selectAllItems(item);

				break;

			case CUSTOMER:
				System.out.println("Entering Customer Read: ");

				break;

			case ORDER:
				System.out.println("Entering Order Read: ");

				break;
				
			case ORDERLINE:
				System.out.println("Entering Orderline Read: ");
				
			default:
				break;
			}

		case UPDATE:
			System.out.println("Entering UPDATE menu: ");
			System.out.println("Please select one of the following: ");

			for (ChooseTable chooseTableUpdate : ChooseTable.values()) {
				System.out.println(chooseTableUpdate.name());
			}

			String selectedToUpdate;
			ChooseTable chooseTableUpdate;

			while (true) {
				try {
					selectedToUpdate = input.getInput();
					chooseTableUpdate = ChooseTable.valueOf(selectedToUpdate.toUpperCase());
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("selection not valid, please re-enter: ");

				}
			}

			switch (chooseTableUpdate) {

			case ITEM:
				System.out.println("Entering Item update: ");
				Input input = new Input();
				
				System.out.println("*********************");

				System.out.println("Please enter/update the item name: ");
				String item_name = input.getInput();

				System.out.println("Please enter/update the price: ");
				double price = input.getNumInput();

				System.out.println("Please enter/update the category: ");
				String category = input.getInput();
				
				System.out.println("Please enter the record ID which you'd like to update");
				int item_id = input.getIntInput();
				
				Item item = new Item(item_id, item_name, price, category);
				ItemAccessObject itemDao = new ItemAccessObject(connection);
				itemDao.updateAnItem(item);
				
				System.out.println(item.getItem_name() + " now updated!");

				break;

			case CUSTOMER:
				System.out.println("Entering Customer update: ");
				Input input1 = new Input();

				System.out.println("*********************");
				System.out.println("Please enter/update the following: ");
				System.out.println("Customer first name: ");
				String first_name = input1.getInput();

				System.out.println("customer last name:");
				String last_name = input1.getInput();

				System.out.println("customer address:");
				String address = input1.getInput();

				System.out.println("customer email:");
				String email = input1.getInput();

				System.out.println("customer password:");
				String _password = input1.getInput();
				
				System.out.println("Please enter the record ID which you'd like to update: ");
				int customer_id = input1.getIntInput();

				Customer customer = new Customer(customer_id, first_name, last_name, address, email, _password);

				CustomerDataAccessObject customerDao = new CustomerDataAccessObject(connection);
				customerDao.updateACustomer(customer);
				System.out.println(customer.getFirst_name() + ", has been updated! ");
				
				
				break;
				
			case ORDERLINE:
				System.out.println("Entering Orderline update: ");
				Input input3 = new Input();
				System.out.println("*********************");
				System.out.println("Please enter/update the following: ");
				System.out.println("Order ID: ");
				int order_id_fk = input3.getIntInput();
				System.out.println("Item ID: ");
				int _item_id_fk = input3.getIntInput();
				System.out.println("Enter quantity:");
				int QTY = input3.getIntInput();
				System.out.println("Please enter the record ID which you'd like to update: ");
				int ol_id = input3.getIntInput();
				
				Orderline orderline = new Orderline(ol_id, order_id_fk, _item_id_fk, QTY);
				
				OrderlineDataAccessObject orderlineDao = new OrderlineDataAccessObject(connection);
				orderlineDao.updateInOrderline(orderline);
				System.out.println("Orderline successfully updated!");
				
				
				break;
				

			case ORDER:
				System.out.println("Entering Order update: ");
				Input input2 = new Input();

				System.out.println("*********************");
				System.out.println("Please enter/update the following: ");
				
				System.out.println("Customer ID: ");
				int cust_id_fk = input2.getIntInput();
				System.out.println("Enter Item ID: ");
				int item_id_fk = input2.getIntInput();
				
				System.out.println("Please enter the record ID which you'd like to update: ");
				int order_id = input2.getIntInput();

				Order order = new Order(order_id, cust_id_fk, item_id_fk, null);

				OrderDataAccessObject orderDao = new OrderDataAccessObject(connection);

				orderDao.updateAnOrder(order);
				System.out.println("Order successfully updated!");

				

				break;
			default:
				break;
			}

			break;
		case DELETE:
			System.out.println("Entering delete menu");
			System.out.println("Please select one of the following: ");

			for (ChooseTable chooseTableDelete : ChooseTable.values()) {
				System.out.println(chooseTableDelete.name());
			}

			String selectedToDelete;
			ChooseTable chooseTableDelete;

			while (true) {
				try {
					selectedToDelete = input.getInput();
					chooseTableDelete = ChooseTable.valueOf(selectedToDelete.toUpperCase());
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("selection not valid, please re-enter: ");

				}
			}

			switch (chooseTableDelete) {

			case ITEM:
				Input input5 = new Input();
				System.out.println("Please enter the id of the item you'd like to delete: ");
				int item_id = input5.getIntInput();
				Item item = new Item(item_id, null, item_id, null);
				ItemAccessObject itemDao = new ItemAccessObject(connection);
				itemDao.deleteAnItem(item);

				System.out.println("Item deleted successfully! ");
				break;

			case CUSTOMER:
				Input input4 = new Input();
				System.out.println("Please enter the ID number of the customer you'd like to delete: ");
				int customer_id = input4.getIntInput();
				Customer cust = new Customer(customer_id, null, null, null, null, null);
				CustomerDataAccessObject customerDao = new CustomerDataAccessObject(connection);
				customerDao.deleteACustomer(cust);

				System.out.println("Customer deleted successfully! ");

				break;

			case ORDER:
				Input input3 = new Input();
				System.out.println("Please enter the ID number of the order you'd like to delete: ");
				int order_id = input3.getIntInput();

				OrderDataAccessObject orderDao = new OrderDataAccessObject(connection);
				Order order = new Order(order_id, order_id, order_id, null);

				orderDao.deleteAnOrder(order);

				System.out.println("order deleted successfully! ");
				break;

			default:
				break;

			}
		default:
			break;

		}

		connection.closeConnection();
	}

}
