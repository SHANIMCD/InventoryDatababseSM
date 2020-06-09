package com.qa.connections;
import com.qa.interfaces.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DriverManager;


public class RemoteJDBC extends JDBC {

	public RemoteJDBC(String user, String password) {
		super(user, password);
	}

	@Override
	public void openConnection() {
		try {
			setConnection(DriverManager.getConnection("jdbc:mysql://35.197.245.66/inventorydb", getUser(), getPassword()));
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new RuntimeException("Cannot connect");
		}
	}

	
	
}
