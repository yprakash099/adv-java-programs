package com.sathya.jdbc;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao {
		
		public int save(Employee emp)
		{
			
			int count=0;
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("insert into emp values(?,?,?)");)
			{
				preparedStatement.setInt(1, emp.getId());
				preparedStatement.setString(2, emp.getName());
				preparedStatement.setDouble(3, emp.getSalary());
				count=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
		
		public Employee findById(int id)
		
		{
			Employee employee=null;
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("select * from emp where id=?");)
			{
				preparedStatement.setInt(1, id);
				ResultSet resultSet=preparedStatement.executeQuery();
				
				if(resultSet.next())
				{
					employee = new Employee();
					employee.setId(resultSet.getInt(1));
					employee.setName(resultSet.getString(2));
					employee.setSalary(resultSet.getDouble(3));
					
				}
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return employee;
		}
		public int deleteById(int id)
		{
			int count=0;
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where id=?");)
			{
				preparedStatement.setInt(1, id);
				count=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
		public int deleteBysalary(double salary)
		{
			int count=0;
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where salary>?");)
			{
				preparedStatement.setDouble(1, salary);
				count=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
		public List<Employee> findAll()
		{
			List<Employee> emps=new ArrayList<Employee>();
			try(Connection connection=DbConnection.createConnection();
					Statement statement=connection.createStatement();)
			{
				ResultSet resultSet=statement.executeQuery("select * from emp");
				while(resultSet.next())
				{
					Employee employee=new Employee();
					employee.setId(resultSet.getInt(1));
					employee.setName(resultSet.getString(2));
					employee.setSalary(resultSet.getDouble(3));
					emps.add(employee);
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return emps;
		}
		public int updateSalary(double currentSalary , double incrementSalary)
		{
			int count=0;
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("update emp set salary=salary+? where salary>?");)
			{
				preparedStatement.setDouble(1, incrementSalary);
				preparedStatement.setDouble(2, currentSalary);
				count=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
}
