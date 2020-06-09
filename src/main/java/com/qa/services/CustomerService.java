package com.qa.services;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import com.qa.dao.CustomerDataAccessObject;
import com.qa.schemas.Customer;

public class CustomerService {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerService.class);
	
	CustomerDataAccessObject accessObject;
	
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
}
