package com.qa.schemas;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private int order_id;
	private List<Orderline> orderlines = new ArrayList<Orderline>();
	private int cust_id_fk;
	
	private Timestamp default_timestamp;
	
	public Order(int cust_id_fk) {
		super();
		this.cust_id_fk = cust_id_fk;
	}

	public Order(int order_id, int cust_id_fk, Timestamp default_timestamp) {
		super();
		this.setOrder_id(order_id);
		this.setCust_id_fk(cust_id_fk);
	
		this.setDefault_timestamp(default_timestamp);
	}

	


	@Override
	public String toString() {
		String reply = "Order [order_id=" + order_id + ", cust_id_fk=" + cust_id_fk
				+ ", default_timestamp=" + default_timestamp + "]";
		for(Orderline orderline : orderlines) {
			reply+= "\r\n " +orderline;
		}
		return reply;
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



	public Timestamp getDefault_timestamp() {
		return default_timestamp;
	}


	public void setDefault_timestamp(Timestamp default_timestamp) {
		this.default_timestamp = default_timestamp;
	}



	
}
