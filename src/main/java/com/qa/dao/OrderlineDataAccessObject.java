package com.qa.dao;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	public JDBC getJdbc() {
		return jdbc;
	}

	public void setJdbc(JDBC jdbc) {
		this.jdbc = jdbc;
	}
	
	
}
