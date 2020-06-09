package com.qa.schemas;

import java.sql.Timestamp;

public class Order {

	private int order_id;
	private int cust_id_fk;
	private int item_id_fk;
	private Timestamp default_timestamp;
	
	
	public Order(int order_id, int cust_id_fk, int item_id_fk, Timestamp default_timestamp) {
		super();
		this.setOrder_id(order_id);
		this.setCust_id_fk(cust_id_fk);
		this.setItem_id_fk(item_id_fk);
		this.setDefault_timestamp(default_timestamp);
	}

	

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", cust_id_fk=" + cust_id_fk + ", item_id_fk=" + item_id_fk
				+ ", default_timestamp=" + default_timestamp + "]";
	}



	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public int getCust_id_fk() {
		return cust_id_fk;
	}


	public void setCust_id_fk(int cust_id_fdk) {
		this.cust_id_fk = cust_id_fdk;
	}


	public int getItem_id_fk() {
		return item_id_fk;
	}


	public void setItem_id_fk(int item_id_fk) {
		this.item_id_fk = item_id_fk;
	}


	public Timestamp getDefault_timestamp() {
		return default_timestamp;
	}


	public void setDefault_timestamp(Timestamp default_timestamp) {
		this.default_timestamp = default_timestamp;
	}



	
}
