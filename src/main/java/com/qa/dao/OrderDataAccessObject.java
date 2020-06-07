package com.qa.dao;

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
	
	public void listAllOrders() {
		String sql = "SELECT * from orders;";
		jdbc.sendQuery(sql);
	}
	
	
	public JDBC getJdbc() {
		return jdbc;
	}

	public void setJdbc(JDBC jdbc) {
		this.jdbc = jdbc;
	}
}
	


