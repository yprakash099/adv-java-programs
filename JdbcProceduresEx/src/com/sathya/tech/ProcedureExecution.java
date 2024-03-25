package com.sathya.tech;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureExecution {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		CallableStatement callableStatement=connection.prepareCall("{call Getsalary(?,?)}");
		callableStatement.setInt(1, 1008);
		callableStatement.registerOutParameter(2, Types.FLOAT);
		callableStatement.executeUpdate();
		System.out.println(callableStatement.getFloat(2));
		connection.close();

	}

}
