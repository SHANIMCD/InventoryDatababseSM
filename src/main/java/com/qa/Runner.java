package com.qa;

import org.apache.log4j.Logger;

import com.qa.connections.JDBC;
import com.qa.connections.RemoteJDBC;

public class Runner {
	public static final Logger LOGGER = Logger.getLogger(Runner.class);

	public static void main(String[] args) {

		Input input = new Input();
		LOGGER.info("Database username: ");
		String user = input.getInput();
		LOGGER.info("Database password: ");
		String password = input.getInput();

		JDBC connection = null;
		try {
			connection = new RemoteJDBC(user, password);
			Inv inv = new Inv(connection);
			inv.start();
		} catch (Exception e) {
			LOGGER.error("unable to connect, please try again: ");
			for (StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}

		Inv inv = new Inv(connection);
		inv.start();
		
		connection.closeConnection();


	}
}
