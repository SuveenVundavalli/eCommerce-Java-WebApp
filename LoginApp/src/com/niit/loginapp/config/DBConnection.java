package com.niit.loginapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String id = "sa";
	private static String password = "sa";
	private static String url = "jdbc:h2:~/target/filter.db";
	private static String driver = "org.h2.Driver";
	
	
	// Static method hence easy call from any class
	public static Connection getDBConnection() {
		
		Connection con = null;
		
		try {
			//load the Driver
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		if( getDBConnection() == null)
		{
			System.out.println("Could not connect to Database");
		}
		else
		{
			System.out.println("Successfully Connected");
		}
	}

}
