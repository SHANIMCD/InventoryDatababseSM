package com.qa.services;

import java.sql.SQLException;
import java.util.List;

import com.qa.Input;
import com.qa.connections.JDBC;
import org.apache.log4j.Logger;

import com.qa.dao.ItemAccessObject;
import com.qa.schemas.Item;

public class ItemService {

	public JDBC connection;
	
	public static final Logger LOGGER = Logger.getLogger(ItemService.class);

	private ItemAccessObject accessObject;
	
	public ItemService(ItemAccessObject accessObject) {
		this.accessObject = accessObject;
		
	}
	
	
	public void displayItems() {
		try {
			List<Item> items = accessObject.selectAllItems();
			for(Item item:items) {
				LOGGER.info(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("unable to read items");
			for(StackTraceElement element:e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
		
	}

	public void createItems() {
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

	}


	public void updateItems() {
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

	}

	public void deleteItem() {
		Input input5 = new Input();
		LOGGER.info("Please enter the id of the item you'd like to delete: ");
		int item_id = input5.getIntInput();
		Item item = new Item(item_id, null, item_id, null);
		ItemAccessObject itemDao = new ItemAccessObject(connection);
		itemDao.deleteAnItem(item);

		LOGGER.info("Item deleted successfully! ");
	}
}
