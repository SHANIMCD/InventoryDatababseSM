package com.qa.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.dao.OrderDataAccessObject;
import com.qa.schemas.Order;

public class OrderService {

	public static final Logger LOGGER = Logger.getLogger(ItemService.class);

	private OrderDataAccessObject accessObject;

	public OrderService(OrderDataAccessObject accessObject) {
		this.accessObject = accessObject;
	}

	public void displayOrders() {
		try {
			List<Order> orders = accessObject.listAllOrders();
			for (Order order : orders) {
				LOGGER.info(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("unable to read items");
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}

}
