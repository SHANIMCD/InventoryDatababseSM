package com.qa;

import java.util.ArrayList;
import java.util.List;

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
		CustomerService customerService = new CustomerService(new CustomerDataAccessObject(connection));
		ItemService itemService = new ItemService(new ItemAccessObject(connection));
		OrderService orderService = new OrderService(new OrderDataAccessObject(connection),
				new OrderlineDataAccessObject(connection));

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
			} catch (IllegalArgumentException e) {
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
				itemService.createItems();
				break;
			case CUSTOMER:
				customerService.insertCustomers();
				break;
			case ORDER:
				LOGGER.info("Please enter customer id:");
				Order order = new Order(input.getIntInput());

				List<Integer> itemIds = new ArrayList<Integer>();
				while (true) {
					LOGGER.info("Enter item id to go in order:");
					Integer itemId = input.getIntInput();
					itemIds.add(itemId);

					LOGGER.info("Would you like yo place another?");
					if (!input.getInput().toLowerCase().equals("yes")) {
						break;
					}
				}
				orderService.createAnOrder(order, itemIds);
				break;
			default:
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
				itemService.displayItems();
				break;
			case CUSTOMER:
				customerService.displayCustomers();
				break;
			case ORDER:
				orderService.displayOrders();
				break;
			default:
				break;
			}
	
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
				itemService.updateItems();
				break;
			case CUSTOMER:
				customerService.updateCustomers();
				break;
			case ORDER:
				orderService.updateOrder();
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
				itemService.deleteItem();
				break;
			case CUSTOMER:
				customerService.deleteCustomer();
				break;
			case ORDER:
				orderService.deleteOrder();
				break;
			default:
				break;
			}
		default:
			break;
		}
	}
}
