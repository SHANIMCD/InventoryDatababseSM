package com.qa;


public class Item {
	
	int item_id = 0; 
	String item_name;
	double price; 
    String category;
    
    
    public Item(int item_id, String item_name, double price, String category) {
    	this.item_id = item_id;
    	this.item_name = item_name;
    	this.price = price;
    	this.category = category;
    }
    
    public void insertSelf() {
    	String query = "INSERT INTO items VALUES (" + item_id +  " , '"
    + item_name + "' , '" + price + "' , '"+ category +" ')";
    	JDBC.exUpdate(query);
    }
    
}
