package com.qa.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.dao.ItemAccessObject;
import com.qa.schemas.Item;

public class ItemService {
	
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
}
