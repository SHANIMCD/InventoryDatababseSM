package com.qa.dao;
import com.qa.connections.JDBC;
import com.qa.schemas.Item;

public class ItemAccessObject {

	private JDBC jdbc;
	
	public ItemAccessObject(JDBC jdbc) {
		this.setJdbc(jdbc);
	}
	
	public void insertAnItem(Item item) {
		String sql = "insert into items(item_name, price, category) values ('"+ item.getItem_name()+ "', "+item.getPrice()+", '" +item.getCategory()+"');";
		
		jdbc.sendUpdate(sql);
	}
	
	public void deleteAnItem(Item item) {
		String sql = "delete from items where item_id = " + item.getItem_id() + ";";
		jdbc.sendUpdate(sql);
	}
	
	
	public void updateAnItem(Item item) {
		String sql = "UPDATE items SET item_name = '" + item.getItem_name() + "', price = " + item.getPrice() + ", category = '" + item.getCategory() + "' WHERE item_id = " + item.getItem_id() + ";";
		jdbc.sendUpdate(sql);
	}

	
	public void selectAllItems(Item item) {
		String sql = "select * from items;";
		jdbc.sendQuery(sql);
	}
	
	public JDBC getJdbc() {
		return jdbc;
	}

	public void setJdbc(JDBC jdbc) {
		this.jdbc = jdbc;
	}
}
