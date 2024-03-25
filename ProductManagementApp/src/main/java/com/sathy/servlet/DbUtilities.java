package com.sathy.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtilities {
	public static Connection createConnection()
	{
		Connection connection=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","manager");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
}
}
