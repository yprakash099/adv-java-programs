package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExecution {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		Statement statement=connection.createStatement();
		statement.addBatch("create table student(sId number,sName varchar2(20),sCity varchar2(20))");
		statement.addBatch("insert into student values(111,'Anvesh','Nellore')");
		statement.addBatch("insert into student values(222,'Prakash','Tirupati')");
		statement.addBatch("insert into student values(333,'Kranti','Vijayawada')");
		statement.addBatch("delete from student where sId=111");
		int[] res=statement.executeBatch();
		for(int result:res)
		{
			System.out.println(result);
		}
		connection.close();
	}

}
