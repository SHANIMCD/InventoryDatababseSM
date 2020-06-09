package com.qa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.connections.JDBC;
import com.qa.schemas.Item;

public class ItemAccessObject {

	private JDBC jdbc;

	public ItemAccessObject(JDBC jdbc) {
		this.setJdbc(jdbc);
	}

	public void insertAnItem(Item item) {
		String sql = "insert into items(item_name, price, category) values ('" + item.getItem_name() + "', "
				+ item.getPrice() + ", '" + item.getCategory() + "');";

		jdbc.sendUpdate(sql);
	}

	public void deleteAnItem(Item item) {
		String sql = "delete from items where item_id = " + item.getItem_id() + ";";
		jdbc.sendUpdate(sql);
	}

	public void updateAnItem(Item item) {
		String sql = "UPDATE items SET item_name = '" + item.getItem_name() + "', price = " + item.getPrice()
				+ ", category = '" + item.getCategory() + "' WHERE item_id = " + item.getItem_id() + ";";
		jdbc.sendUpdate(sql);
	}

	public List<Item> selectAllItems() throws SQLException {
		String sql = "select item_id, item_name, price, category from items;";
		ResultSet resultSet = jdbc.sendQuery(sql);
		List<Item> items = new ArrayList<Item>();
		while (resultSet.next()) {

			int item_id = resultSet.getInt("item_id");
			String item_name = resultSet.getString("item_name");
			double price = resultSet.getDouble("price");
			String category = resultSet.getString("category");
			

			Item item = new Item(item_id, item_name, price, category);
			items.add(item);
			
		}
		return items;
	}

	public JDBC getJdbc() {
		return jdbc;
	}

	public void setJdbc(JDBC jdbc) {
		this.jdbc = jdbc;
	}
}
