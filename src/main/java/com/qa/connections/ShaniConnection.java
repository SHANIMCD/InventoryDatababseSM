package com.qa.connections;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.qa.connections.JDBC;
import com.qa.interfaces.*;

public class ShaniConnection extends JDBC {

	public ShaniConnection(String user, String password) {
		super(user, password);
		
	}

	
	@Override
	public void openConnection() {
		// TO DO SQL EXECEPTIONS LATER
		try {
			setConnection(DriverManager.getConnection("mysql://94.76.82.60", getUser(), getPassword()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
