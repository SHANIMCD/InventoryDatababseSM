package com.qa;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.connections.RemoteJDBC;

import com.qa.Input;



public class Runner {
	public static final Logger LOGGER = Logger.getLogger(Runner.class);
	public static void main(String[] args) {
	
		while(true) {
			Input input = new Input();
			LOGGER.info("Database username: ");
			String user = input.getInput();
			LOGGER.info("Database password: ");
			String password = input.getInput();
			
			RemoteJDBC connection;
			try {
				connection = new RemoteJDBC(user, password);
				Inv inv = new Inv(connection);	
				inv.start();		
			} catch(Exception e) {
				LOGGER.error("unable to connect, please try again: ");	
			}
				
		}
	
		
		
		
		
	}
}
