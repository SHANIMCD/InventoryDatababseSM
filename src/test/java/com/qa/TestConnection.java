package com.qa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	
//	static final String SCHEMA_LOCATION = "src\\test\\resources\\SchemaFile.sql";
//	static final String DATA_LOCATION = "src\\test\\resources\\dataFile.sql";
//
//	private static void sendToDB(Connection connection, String fileLocation) {
//        try (BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
//            String string;
//            while ((string = br.readLine()) != null) {
//                try (Statement statement = connection.createStatement();) {
//                    statement.executeUpdate(string);
//                }
//            }
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//	
//	@BeforeClass
//	public static void init() {
//		sendToDB(DriverManager.getConnection("jdbc:mysql://35.197.245.66/inventorydb", "root", "_takeaguess"), SCHEMA_LOCATION);
//	}
//	
//	@Before
//	public void setUp() {
//		JDBC = new TestConnection
//	}
}
