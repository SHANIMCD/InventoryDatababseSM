package com.qa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://35.197.245.66/inventorydb";
	static final String USER = "root";
	static final String PASS = "_takeaguess";
	
	static Connection conn = null;
	static Statement stmt = null;
	
	static void connect() { 
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	
	static void exUpdate(String query) {
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static ResultSet exquery(String query ) {
		ResultSet response = null;
		try {
			response = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}

}



