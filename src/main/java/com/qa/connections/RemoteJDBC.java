package com.qa.connections;
import java.sql.DriverManager;
import java.sql.SQLException;


public class RemoteJDBC extends JDBC {

	public RemoteJDBC(String user, String password) {
		super(user, password);
	}

	@Override
	public void openConnection() {
		try {
			setConnection(DriverManager.getConnection("jdbc:mysql://35.197.245.66/inventorydb", getUser(), getPassword()));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot connect");
		}
	}

	
	
}
