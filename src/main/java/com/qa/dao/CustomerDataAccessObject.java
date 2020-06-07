package com.qa.dao;

import com.qa.schemas.Customer;
import com.qa.connections.*;

public class CustomerDataAccessObject {

	private JDBC jdbc;
	
	public CustomerDataAccessObject(JDBC jdbc) {
		this.setJdbc(jdbc);
	}
	
	public void insertCustomer(Customer customer ) {
		String sql = "insert into customer(first_name, last_name, address, email, password) values ('" + customer.getFirst_name() + "', '" + customer.getLast_name() + "', '" + customer.getAddress() + "', '" + customer.getEmail() + "', '" + customer.getPassword()+ "');";
		jdbc.sendUpdate(sql);
	}
	
	
	public void deleteACustomer(Customer customer) {
		String sql = "delete from customer where customer_id = " + customer.getCustomerId()  + ";";
		jdbc.sendUpdate(sql);
	}

	
	public void updateACustomer(Customer customer) {
		String sql = " UPDATE customer SET first_name = '" + customer.getFirst_name() + "', last_name = '" + customer.getLast_name() + "', address = '" + customer.getAddress() + "', email = '" + customer.getEmail() + "', password = '" + customer.getPassword() + "' WHERE customer_id = " + customer.getCustomerId() + ";"; 
		jdbc.sendUpdate(sql);
	}
	
	public JDBC getJdbc() {
		return jdbc;
	}

	public void setJdbc(JDBC jdbc) {
		this.jdbc = jdbc;
	}
}
