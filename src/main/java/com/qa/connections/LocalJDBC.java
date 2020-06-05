package com.qa.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.qa.interfaces.*;

public class LocalJDBC extends JDBC {

	
	
	public LocalJDBC(String user, String password) {
		super(user, password);
	}

	public void openConnection() {
		// TO CHANGE SQLEXCEPTION LATER
		try {
			setConnection(DriverManager.getConnection("jdbc:mysql://34.53.233.12:3306/ims?serverTimezone=BST", getUser(), getPassword()));;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


}
