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
			System.out.println("Database username: ");
			String user = input.getInput();
			System.out.println("Database password: ");
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
