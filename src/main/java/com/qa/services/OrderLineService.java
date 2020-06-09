package com.qa.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.dao.OrderlineDataAccessObject;
import com.qa.schemas.Orderline;

public class OrderLineService {

	public static final Logger LOGGER = Logger.getLogger(ItemService.class);

	private OrderlineDataAccessObject accessObject;

	public OrderLineService(OrderlineDataAccessObject accessObject) {
		this.accessObject = accessObject;
	}

	public void displayTheOrderLine() {
		try {
			List<Orderline> orderlines = accessObject.showTheOrderline();
			for (Orderline orderline: orderlines) {
				LOGGER.info(orderline);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("unable to read orderlines");
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}

	}

}