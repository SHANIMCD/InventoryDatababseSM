package com.qa.connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.qa.exceptions.ConnectionNotMadeException;
import com.qa.exceptions.SqlStatementNotUnderstoodException;
import com.qa.interfaces.Closable;
import com.qa.interfaces.Openable;
import com.qa.interfaces.Queryable;


public abstract class JDBC implements Openable, Closable, Queryable {
	
	public static final Logger LOGGER = Logger.getLogger(JDBC.class);
	
	private String user;
	private String password;
	private Connection connection;
	

	public JDBC(String user, String password) {
		this.user = user;
		this.password = password;
		openConnection();
	}
	

	public abstract void openConnection();
	
	public void closeConnection() {
		try {
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new ConnectionNotMadeException("connection could not be made");
		}
	}


	public ResultSet sendQuery(String sql) {
	
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SqlStatementNotUnderstoodException("could not execute: " + sql);
		}
	}
	
	public void sendUpdate(String sql) {
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			throw new SqlStatementNotUnderstoodException("could not execute: " + sql);
		}
		
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
	



