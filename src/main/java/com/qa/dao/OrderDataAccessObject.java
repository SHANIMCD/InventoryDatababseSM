package com.qa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.qa.connections.JDBC;
import com.qa.schemas.Order;

public class OrderDataAccessObject {
	
	private JDBC jdbc;
	
	public OrderDataAccessObject(JDBC jdbc) {
		this.setJdbc(jdbc);
	}

	public void insertAnOrder(Order order) {
		String sql = "insert into orders (cust_id_fk, item_id_fk) values (" + order.getCust_id_fk() + ", " + order.getItem_id_fk() + ");";
		
		jdbc.sendUpdate(sql);
	}
	
	
	public void deleteAnOrder(Order order) {
		String sql = " delete from orders where order_id = " + order.getOrder_id() + ";";
		jdbc.sendUpdate(sql);
	}
	
	public void updateAnOrder(Order order) {
		String sql = " UPDATE orders SET cust_id_fk = " + order.getCust_id_fk() + ", item_id_fk = " + order.getItem_id_fk() + " WHERE order_id = " + order.getOrder_id() + ";"; 
		jdbc.sendUpdate(sql);
	}
	
	public List<Order> listAllOrders() throws SQLException {
		String sql = "SELECT * from orders;";
		ResultSet resultSet = jdbc.sendQuery(sql);
		List<Order> orders = new ArrayList<Order>();
		while(resultSet.next()) {
			
			int order_id = resultSet.getInt("order_id");
			int cust_id_fk = resultSet.getInt("cust_id_fk");
			int item_id_fk = resultSet.getInt("item_id_fk");
			Timestamp default_timestamp = resultSet.getTimestamp("datetime_placed");
			
			Order order = new Order(order_id, cust_id_fk, item_id_fk, default_timestamp);
			orders.add(order);
			
		}
		return orders;
	}
	
	
	public JDBC getJdbc() {
		return jdbc;
	}

	public void setJdbc(JDBC jdbc) {
		this.jdbc = jdbc;
	}
}
	


