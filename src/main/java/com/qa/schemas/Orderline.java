package com.qa.schemas;

public class Orderline {
	
	private int ol_id;
	int order_id_fk;
	int item_id_fk;
	int QTY;
	
	public Orderline(int ol_id, int order_id_fk, int item_id_fk, int QTY) {
		super();
		this.ol_id = ol_id;
		this.order_id_fk = order_id_fk;
		this.item_id_fk = item_id_fk;
		this.QTY = QTY;
	}
	
	public int getOl_id() {
		return ol_id;
	}

	public void setOl_id(int ol_id) {
		this.ol_id = ol_id;
	}

	public int getOrder_id_fk() {
		return order_id_fk;
	}

	public void setOrder_id_fk(int order_id_fk) {
		this.order_id_fk = order_id_fk;
	}

	public int getItem_id_fk() {
		return item_id_fk;
	}

	public void setItem_id_fk(int item_id_fk) {
		this.item_id_fk = item_id_fk;
	}

	public int getQTY() {
		return QTY;
	}

	public void setQTY(int qTY) {
		QTY = qTY;
	}

	@Override
	public String toString() {
		return "Orderline [ol_id=" + ol_id + ", order_id_fk=" + order_id_fk + ", item_id_fk=" + item_id_fk + ", QTY="
				+ QTY + "]";
	}

	

}
