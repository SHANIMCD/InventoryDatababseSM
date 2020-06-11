package com.qa.factory;

import org.apache.log4j.Logger;

import com.qa.Input;
import com.qa.Inv;
import com.qa.Runner;
import com.qa.connections.JDBC;
import com.qa.connections.RemoteJDBC;

public class Factory {
	public static final Logger LOGGER = Logger.getLogger(Factory.class);
	static Factory factory = null;
	Inv inv = null;
	static JDBC connection = null;
	
	private Factory() {
		
	}
	
	public static JDBC getDB() {
		if (connection == null) {
			Input input = new Input();
			LOGGER.info("Database username: ");
			String user = input.getInput();
			LOGGER.info("Database password: ");
			String password = input.getInput();
			connection = new RemoteJDBC(user, password);
			return connection;
		} else {
			return connection;
		}
	}
	
	public static Factory getFactInstance() {
		if (factory != null) {
			return factory;
		} else  {
			factory = new Factory();
			return factory;
		}
	}

} 
