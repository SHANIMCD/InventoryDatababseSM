package com.qa.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.connections.JDBC; 
import com.qa.schemas.Orderline;


public class OrderlineDataAccessObject {

	private JDBC jdbc;
	
	public OrderlineDataAccessObject(JDBC jdbc) {
		this.setJdbc(jdbc);
	}
	
	
	public void insertIntoORderline(Orderline orderline) {
		String sql = " insert into orderline(order_id_fk, item_id_fk, QTY) values (" + orderline.getOrder_id_fk() +  ", " + orderline.getItem_id_fk() + ", " + orderline.getQTY() +");";  
		jdbc.sendUpdate(sql);
	}

	
	
	public void updateInOrderline(Orderline orderline) {
		String sql = " update orderline SET order_id_fk =  " + orderline.getOrder_id_fk() + ",  item_id_fk = " + orderline.getItem_id_fk() + ", QTY = " + orderline.getQTY() + " WHERE ol_id = " + orderline.getOl_id()+ ";";
		jdbc.sendUpdate(sql);
	}
	
	public List<Orderline> showTheOrderlineByOrderId(int orderId) throws SQLException {
		String sql = "select * from orderline where order_id_fk = " +orderId;
		ResultSet resultSet = jdbc.sendQuery(sql);
		List<Orderline> orderlines = new ArrayList<Orderline>();
		while (resultSet.next()) {
			
			int ol_id = resultSet.getInt("ol_id");
			int order_id_fk = resultSet.getInt("order_id_fk");
			int item_id_fk = resultSet.getInt("item_id_fk");
			int QTY = resultSet.getInt("QTY");
			
			Orderline orderline = new Orderline(ol_id, order_id_fk, item_id_fk, QTY);
			orderlines.add(orderline);
		}
		return orderlines;
	}
	
	public JDBC getJdbc() {
		return jdbc;
	}

	public void setJdbc(JDBC jdbc) {
		this.jdbc = jdbc;
	}
	
	
}
