package com.qa.dao;
import com.qa.connections.JDBC;
import com.qa.schemas.Item;

public class ItemAccessObject {

	private JDBC jdbc;
	
	public ItemAccessObject(JDBC jdbc) {
		this.setJdbc(jdbc);
	}
	
	public void insertAnItem(Item item) {
		String sql = "insert into items(item_name, price, category) values (' " + item.getItem_name() + "' , '" + item.getPrice() + "' , '" + item.getCategory() + " ');  ";
		
		jdbc.sendUpdate(sql);
	}

	
	public JDBC getJdbc() {
		return jdbc;
	}

	public void setJdbc(JDBC jdbc) {
		this.jdbc = jdbc;
	}
}
