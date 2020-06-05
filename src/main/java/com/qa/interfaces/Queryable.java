package com.qa.interfaces;

import java.sql.ResultSet;


public interface Queryable {

	public ResultSet sendQuery(String sql);
	
	public void sendUpdate(String sql);
}
