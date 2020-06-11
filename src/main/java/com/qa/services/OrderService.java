package com.qa.services;

import java.sql.SQLException;
import java.util.List;

import com.qa.Input;
import com.qa.connections.JDBC;
import org.apache.log4j.Logger;

import com.qa.dao.OrderDataAccessObject;
import com.qa.dao.OrderlineDataAccessObject;
import com.qa.schemas.Order;
import com.qa.schemas.Orderline;

public class OrderService {

	public static final Logger LOGGER = Logger.getLogger(ItemService.class);

	private OrderDataAccessObject accessObject;
	private OrderlineDataAccessObject orderlineDataAccessObject;

	public OrderService(OrderDataAccessObject accessObject, OrderlineDataAccessObject orderlineDataAccessObject) {
		this.accessObject = accessObject;
		this.orderlineDataAccessObject = orderlineDataAccessObject;
	}

	public void displayOrders() {
		try {
			List<Order> orders = accessObject.listAllOrders();
			for (Order order : orders) {
				LOGGER.info(order);
				List<Orderline> orderlines = orderlineDataAccessObject.showTheOrderlineByOrderId(order.getOrder_id());
				for(Orderline orderline : orderlines) {
					LOGGER.info(orderline);
				}
				LOGGER.info("----");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("unable to read items");
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
	}

	public void createAnOrder(Order order, List<Integer> itemIds) {
		LOGGER.info("Order create: ");

		int orderId = 0;
		try {
			orderId = accessObject.insertAnOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Integer itemId : itemIds) {
			Orderline orderline = new Orderline(orderId, itemId);
			orderlineDataAccessObject.insertIntoORderline(orderline);
		}

		LOGGER.info(" Successfully added into orderline");

	}

	public void updateOrder() {
		LOGGER.info("Order update: ");
		Input input2 = new Input();

		LOGGER.info("Please enter/update the following: ");

		LOGGER.info("Customer ID: ");
		int cust_id_fk = input2.getIntInput();

		LOGGER.info("Please enter the record ID which you'd like to update: ");
		int order_id = input2.getIntInput();

		Order order = new Order(order_id, cust_id_fk, null);

//		OrderDataAccessObject orderDao = new OrderDataAccessObject(connection);
//
//		orderDao.updateAnOrder(order);
		LOGGER.info("Order successfully updated!");
	}

	public void deleteOrder() {
		Input input3 = new Input();
		LOGGER.info("Please enter the ID number of the order you'd like to delete: ");
		int order_id = input3.getIntInput();

//		OrderDataAccessObject orderDao = new OrderDataAccessObject(connection);
//		Order order = new Order(order_id, order_id, order_id, null);

//		orderDao.deleteAnOrder(order);

		LOGGER.info("order deleted successfully! ");
	}

}
