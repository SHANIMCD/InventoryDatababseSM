package com.qa.services;

import java.sql.SQLException;
import java.util.List;
import com.qa.connections.JDBC;
import com.qa.Input;
import org.apache.log4j.Logger;
import com.qa.dao.CustomerDataAccessObject;
import com.qa.schemas.Customer;

public class CustomerService {

	public static final Logger LOGGER = Logger.getLogger(CustomerService.class);
	
	private CustomerDataAccessObject accessObject;
	
	public CustomerService(CustomerDataAccessObject accessObject) {
		this.accessObject = accessObject;
	}

	
	public void displayCustomers() {
		try {
			List<Customer> customers = accessObject.selectAllCustomers();
			for(Customer customer:customers) {
				LOGGER.info(customer);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("unable to read customers");
			for(StackTraceElement element:e.getStackTrace() ) {
				LOGGER.debug(element);
			}
			
		}
	}

	public void insertCustomers() {

		Input input1 = new Input();

		LOGGER.info("customer first name:");
		String first_name = input1.getInput();

		LOGGER.info("customer last name:");
		String last_name = input1.getInput();

		LOGGER.info("customer address:");
		String address = input1.getInput();

		LOGGER.info("customer email:");
		String email = input1.getInput();

		LOGGER.info("customer password:");
		String sausage = input1.getInput();

		Customer customer = new Customer(1, first_name, last_name, address, email, sausage);
		accessObject.insertCustomer(customer);
		LOGGER.info(customer.getFirst_name() + ", has been added to the database. ");

	}

	public void updateCustomers() {
		LOGGER.info("Customer update Menu: ");
		Input input1 = new Input();

		LOGGER.info("Please enter/update the following: ");
		LOGGER.info("Customer first name: ");
		String first_name = input1.getInput();

		LOGGER.info("customer last name:");
		String last_name = input1.getInput();

		LOGGER.info("customer address:");
		String address = input1.getInput();

		LOGGER.info("customer email:");
		String email = input1.getInput();

		LOGGER.info("customer password:");
		String _password = input1.getInput();

		LOGGER.info("Please enter the record ID which you'd like to update: ");
		int customer_id = input1.getIntInput();

		Customer customer = new Customer(customer_id, first_name, last_name, address, email, _password);

		accessObject.updateACustomer(customer);
		LOGGER.info(customer.getFirst_name() + ", has been updated! ");
	}

	public void deleteCustomer() {
		Input input4 = new Input();
		LOGGER.info("Please enter the ID number of the customer you'd like to delete: ");
		int customer_id = input4.getIntInput();
		Customer cust = new Customer(customer_id, null, null, null, null, null);
		accessObject.deleteACustomer(cust);

		LOGGER.info("Customer deleted successfully! ");
	}
}
