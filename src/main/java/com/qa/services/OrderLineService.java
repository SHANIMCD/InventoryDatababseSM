package com.qa.services;

import java.sql.SQLException;
import java.util.List;

import com.qa.Input;
import org.apache.log4j.Logger;

import com.qa.dao.OrderlineDataAccessObject;
import com.qa.schemas.Orderline;
import com.qa.connections.JDBC;

public class OrderLineService {

//	public JDBC connection;
//
//	public static final Logger LOGGER = Logger.getLogger(ItemService.class);
//
//	private OrderlineDataAccessObject accessObject;
//
//	public OrderLineService(OrderlineDataAccessObject accessObject) {
//		this.accessObject = accessObject;
//	}
//
//	public void displayTheOrderLine() {
//		try {
//			List<Orderline> orderlines = accessObject.showTheOrderline();
//			for (Orderline orderline: orderlines) {
//				LOGGER.info(orderline);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			LOGGER.error("unable to read orderlines");
//			for (StackTraceElement element : e.getStackTrace()) {
//				LOGGER.debug(element);
//			}
//		}
//
//	}
//
//	public void createOrderline() {
//		Input input3 = new Input();
//		LOGGER.info("Orderline create: ");
//		LOGGER.info("Enter order ID: ");
//		int order_id_fk = input3.getIntInput();
//		LOGGER.info("Enter Item ID: ");
//		int _item_id_fk = input3.getIntInput();
//		LOGGER.info("Enter Item quantity: ");
//		int QTY = input3.getIntInput();
//
//		Orderline orderline = new Orderline(0, order_id_fk, _item_id_fk, QTY);
//		OrderlineDataAccessObject orderlineDao = new OrderlineDataAccessObject(connection);
//		orderlineDao.insertIntoORderline(orderline);
//
//		LOGGER.info("Order successfully added");
//	}
//
//	public void updateInOrderline() {
//		LOGGER.info("Orderline update: ");
//		Input input3 = new Input();
//		LOGGER.info("Please enter/update the following: ");
//		LOGGER.info("Order ID: ");
//		int order_id_fk = input3.getIntInput();
//		LOGGER.info("Item ID: ");
//		int _item_id_fk = input3.getIntInput();
//		LOGGER.info("Enter quantity:");
//		int QTY = input3.getIntInput();
//		LOGGER.info("Please enter the record ID which you'd like to update: ");
//		int ol_id = input3.getIntInput();
//
//		Orderline orderline = new Orderline(ol_id, order_id_fk, _item_id_fk, QTY);
//
//		OrderlineDataAccessObject orderlineDao = new OrderlineDataAccessObject(connection);
//		orderlineDao.updateInOrderline(orderline);
//		LOGGER.info("Orderline successfully updated!");
//	}

}