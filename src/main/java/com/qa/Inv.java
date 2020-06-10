package com.qa;

import org.apache.log4j.Logger;

import com.qa.connections.Action;
import com.qa.connections.ChooseTable;
import com.qa.connections.JDBC;
import com.qa.dao.CustomerDataAccessObject;
import com.qa.dao.ItemAccessObject;
import com.qa.dao.OrderDataAccessObject;
import com.qa.dao.OrderlineDataAccessObject;
import com.qa.schemas.Customer;
import com.qa.schemas.Item;
import com.qa.schemas.Order;
import com.qa.schemas.Orderline;
import com.qa.services.CustomerService;
import com.qa.services.ItemService;
import com.qa.services.OrderLineService;
import com.qa.services.OrderService;

public class Inv {

	public static final Logger LOGGER = Logger.getLogger(Inv.class);

	Input input = new Input();
	private JDBC connection;

	public Inv(JDBC jdbc) {
		this.connection = jdbc;
	}

	public void start() {

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
				LOGGER.warn("selection not valid, please re-enter: ");
			}
		}
		

		// --- End of Actions for selecting INSERT, READ, UPDATE, DELETE --- //

		// ---- Menu Begins ---- //

		switch (selectedChoice) {
		
		case EXIT: 
			LOGGER.info("Exiting Application, Goodbye!");
			System.exit(0);
			break;
			
		case INSERT:
			LOGGER.info("Entering insert menu: ");
			LOGGER.info("Please select one of the following: ");

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
					LOGGER.warn("selection not valid, please re-enter: ");

				}
			}

			switch (selectTable) {

			case BACK:

				start();

				break;

			case ITEM:

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
				LOGGER.info(item_name + " successfully added!");

				break;

			case CUSTOMER:

				Input input1 = new Input();

				LOGGER.info("customer first name:");
				String first_name = input1.getInput();

				LOGGER.info("customer last name:");
				String last_name = input1.getInput();

				LOGGER.info("customer address:");
				String address = input1.getInput();

				LOGGER.info("customer email:");
				String email = input1.getInput();

				LOGGER.info("customer password:");
				String sausage = input1.getInput();

				Customer customer = new Customer(1, first_name, last_name, address, email, sausage);

				CustomerDataAccessObject customerDao = new CustomerDataAccessObject(connection);
				customerDao.insertCustomer(customer);
				LOGGER.info(customer.getFirst_name() + ", has been added to the database ");

				break;

			case ORDERLINE:
				Input input3 = new Input();
				LOGGER.info("Orderline create: ");
				LOGGER.info("Enter order ID: ");
				int order_id_fk = input3.getIntInput();
				LOGGER.info("Enter Item ID: ");
				int _item_id_fk = input3.getIntInput();
				LOGGER.info("Enter Item quantity: ");
				int QTY = input3.getIntInput();

				Orderline orderline = new Orderline(0, order_id_fk, _item_id_fk, QTY);
				OrderlineDataAccessObject orderlineDao = new OrderlineDataAccessObject(connection);
				orderlineDao.insertIntoORderline(orderline);

				LOGGER.info("Order successfully added");

				break;

			case ORDER:
				Input input2 = new Input();
				LOGGER.info("Order create: ");
				System.out.println("Enter Customer ID: ");
				int cust_id_fk = input2.getIntInput();
				LOGGER.info("Enter Item ID: ");
				int item_id_fk = input2.getIntInput();

				Order order = new Order(1, cust_id_fk, item_id_fk, null);

				OrderDataAccessObject orderDao = new OrderDataAccessObject(connection);

				orderDao.insertAnOrder(order);
				LOGGER.info(" Successfully added into orderline");

				break;
			default:
				connection.closeConnection();

			}

			break;

		case READ:
			LOGGER.info("READ menu: ");
			LOGGER.info("Please type one of the following: ");

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
					LOGGER.warn("selection not valid, please re-enter: ");

				}
			}

			switch (chooseTableRead) {

			case BACK:

				start();

				break;

			case ITEM:

				ItemService itemService = new ItemService(new ItemAccessObject(connection));
				itemService.displayItems();

				break;

			case CUSTOMER:
				CustomerService customerService = new CustomerService(new CustomerDataAccessObject(connection));
				customerService.displayCustomers();

				break;

			case ORDER:
				OrderService orderService = new OrderService(new OrderDataAccessObject(connection));
				orderService.displayOrders();

				break;

			case ORDERLINE:
				OrderLineService orderLineService = new OrderLineService(new OrderlineDataAccessObject(connection));
				orderLineService.displayTheOrderLine();

			default:
				break;
			}

			connection.closeConnection();
			break;

		case UPDATE:
			LOGGER.info("UPDATE Menu: ");
			LOGGER.info("Please type one of the following: ");

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
					LOGGER.warn("selection not valid, please re-enter: ");

				}
			}

			switch (chooseTableUpdate) {

			case BACK:

				start();

				break;

			case ITEM:
				LOGGER.info("ITEM UPDATE: ");
				Input input = new Input();

				LOGGER.info("Please enter/update the item name: ");
				String item_name = input.getInput();

				LOGGER.info("Please enter/update the price: ");
				double price = input.getNumInput();

				LOGGER.info("Please enter/update the category: ");
				String category = input.getInput();

				LOGGER.info("Please enter the record ID which you'd like to update");
				int item_id = input.getIntInput();

				Item item = new Item(item_id, item_name, price, category);
				ItemAccessObject itemDao = new ItemAccessObject(connection);
				itemDao.updateAnItem(item);

				LOGGER.info(item.getItem_name() + " now updated!");

				break;

			case CUSTOMER:
				LOGGER.info("Customer update Menu: ");
				Input input1 = new Input();

				LOGGER.info("Please enter/update the following: ");
				LOGGER.info("Customer first name: ");
				String first_name = input1.getInput();

				LOGGER.info("customer last name:");
				String last_name = input1.getInput();

				LOGGER.info("customer address:");
				String address = input1.getInput();

				LOGGER.info("customer email:");
				String email = input1.getInput();

				LOGGER.info("customer password:");
				String _password = input1.getInput();

				LOGGER.info("Please enter the record ID which you'd like to update: ");
				int customer_id = input1.getIntInput();

				Customer customer = new Customer(customer_id, first_name, last_name, address, email, _password);

				CustomerDataAccessObject customerDao = new CustomerDataAccessObject(connection);
				customerDao.updateACustomer(customer);
				LOGGER.info(customer.getFirst_name() + ", has been updated! ");

				break;

			case ORDERLINE:
				LOGGER.info("Orderline update: ");
				Input input3 = new Input();
				LOGGER.info("Please enter/update the following: ");
				LOGGER.info("Order ID: ");
				int order_id_fk = input3.getIntInput();
				LOGGER.info("Item ID: ");
				int _item_id_fk = input3.getIntInput();
				LOGGER.info("Enter quantity:");
				int QTY = input3.getIntInput();
				LOGGER.info("Please enter the record ID which you'd like to update: ");
				int ol_id = input3.getIntInput();

				Orderline orderline = new Orderline(ol_id, order_id_fk, _item_id_fk, QTY);

				OrderlineDataAccessObject orderlineDao = new OrderlineDataAccessObject(connection);
				orderlineDao.updateInOrderline(orderline);
				LOGGER.info("Orderline successfully updated!");

				break;

			case ORDER:
				LOGGER.info("Order update: ");
				Input input2 = new Input();

				LOGGER.info("Please enter/update the following: ");

				LOGGER.info("Customer ID: ");
				int cust_id_fk = input2.getIntInput();
				LOGGER.info("Enter Item ID: ");
				int item_id_fk = input2.getIntInput();

				LOGGER.info("Please enter the record ID which you'd like to update: ");
				int order_id = input2.getIntInput();

				Order order = new Order(order_id, cust_id_fk, item_id_fk, null);

				OrderDataAccessObject orderDao = new OrderDataAccessObject(connection);

				orderDao.updateAnOrder(order);
				LOGGER.info("Order successfully updated!");

				break;
			default:
				break;
			}

			break;
		case DELETE:
			LOGGER.info("Delete menu");
			LOGGER.info("Please select one of the following: ");

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
					LOGGER.warn("selection not valid, please re-enter: ");

				}
			}

			switch (chooseTableDelete) {

			case BACK:

				start();

				break;

			case ITEM:
				Input input5 = new Input();
				LOGGER.info("Please enter the id of the item you'd like to delete: ");
				int item_id = input5.getIntInput();
				Item item = new Item(item_id, null, item_id, null);
				ItemAccessObject itemDao = new ItemAccessObject(connection);
				itemDao.deleteAnItem(item);

				LOGGER.info("Item deleted successfully! ");
				break;

			case CUSTOMER:
				Input input4 = new Input();
				LOGGER.info("Please enter the ID number of the customer you'd like to delete: ");
				int customer_id = input4.getIntInput();
				Customer cust = new Customer(customer_id, null, null, null, null, null);
				CustomerDataAccessObject customerDao = new CustomerDataAccessObject(connection);
				customerDao.deleteACustomer(cust);

				LOGGER.info("Customer deleted successfully! ");

				break;

			case ORDER:
				Input input3 = new Input();
				LOGGER.info("Please enter the ID number of the order you'd like to delete: ");
				int order_id = input3.getIntInput();

				OrderDataAccessObject orderDao = new OrderDataAccessObject(connection);
				Order order = new Order(order_id, order_id, order_id, null);

				orderDao.deleteAnOrder(order);

				LOGGER.info("order deleted successfully! ");
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
