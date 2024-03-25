package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionExample {
		
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		Statement  statement=null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		 statement=connection.createStatement();
		 connection.setAutoCommit(false);
		statement.executeUpdate("insert into emp values(1122,'John',2000)");
		statement.executeUpdate("insert into emp values(1133,'Abraham',2500)");
		statement.executeUpdate("insert into emp values(1144,'Linchon',30000)");
		//statement.executeUpdate("delete from emp where id=1144");
		

		connection.commit();
		System.out.println("Transaction Successfull...");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			connection.rollback();
			System.out.println("Transaction fail...");
			e.printStackTrace();
		}
		finally {
			if(connection != null)
				connection.close();
			if(statement != null)
				statement.close();
		}
	}

}
