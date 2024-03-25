package com.sathya.jdbc;


import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException  {
		
		//step1:-Load the driver.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded Successfully,,,,,,,,,,,,,");
		
		//step2:-Create Connection.
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		System.out.println("Connection Created Successfully,,,,,,,,,,,,");
		
		//Step3:-
		Statement statement=connection.createStatement();
		String q1="create table emp(id number,name varchar2(10),salary number)";
		int res =statement.executeUpdate(q1);
		System.out.println("created table succesfuly....."+res);
		
		
		
	
		
		//step4:-close the resources
		
		connection.close();
		System.out.println("Connection Closed Successfully,,,,,");
	}

}
