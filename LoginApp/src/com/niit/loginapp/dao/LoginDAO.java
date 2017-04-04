package com.niit.loginapp.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.niit.loginapp.config.DBConnection;

public class LoginDAO {

	//write simple method which takes two parameters and return boolean

	public boolean isValidCredentials(String id, String password){

		//Get the connection
		Connection con = DBConnection.getDBConnection();
		
		//write query  
		/*
		 * Types of Queries/Statements JDBC
		 * 1. Statement				: Used to create static query (Without having where condition)
		 * 2. Prepared Statement	: Used to create dynamic condition (with where condition)
		 * 3. Stored Statement		: DB procedure/function which execute in DB server itself.
		 * 
		 * To validate whether credentials are correct or not
		 * 1. Query : select * from user where id=? and password=?    // This is a dynamic query
		 */
		
		try {
			//write query
			PreparedStatement pStatement = con.prepareStatement("select * from TUser where id=? and password=?");
			pStatement.setString(1, id);
			pStatement.setString(2, password);
			//execute query
			ResultSet resultSet = pStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
				
		

		//Temporarily assuming that id and password is niit
		/*
		if(id.equals("niit") && password.equals("niit")) 
		{
			return true;
		}
		else
		{ 
			return false;
		} */
	}
	
	// want to display all users
	public void getAllUsers(){
		Connection con = DBConnection.getDBConnection();
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from tuser");
			while(resultSet.next()){
				System.out.print(resultSet.getString(1)+"\t");
				System.out.println(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//add info in DB
	public void createRecord(String id, String password)
	{
		Connection con = DBConnection.getDBConnection();
		
		try {
			Statement statement = con.createStatement();
			String query = "insert into tuser(id,password) values("+id+","+password+")";
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	public static void main(String[] args) {
		LoginDAO loginDAO = new LoginDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to enter info in DB \n 1. Yes \n 2. No");
		int choise = sc.nextInt();
		if(choise==1)
		{
			System.out.println("Enter username");
			String uName = sc.next();
			System.out.println("Enter password");
			String pWord = sc.next();
			loginDAO.createRecord("'"+uName+"'"," '"+pWord+"'");
		}
		loginDAO.getAllUsers();
	}
	*/


}
