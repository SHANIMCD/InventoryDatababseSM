package com.qa.schemas;

public class Customer {

	private int customer_id;
	private String first_name;
	private String last_name;
	private String address;
	private String email;
	private String password;
	
	public Customer(int customer_id, String first_name, String last_name, String address, String email, String password ) {
		super();
		this.customer_id = customer_id;
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setAddress(address);
		this.setEmail(email);
		this.setPassword(password);
	}
	
	
	public int getCustomerId() {
		return customer_id;
	}
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", address=" + address + ", email=" + email + ", password=" + password + "]";
	}


	public int setCustomerId() {
		return customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
