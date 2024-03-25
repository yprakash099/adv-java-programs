package com.sathya.jdbc;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao {
	
	public int  createProductTable()
	{	int result=0;
		try(Connection connection=DbConnection.createConnection();
				Statement statement=connection.createStatement();)
		{
			result=statement.executeUpdate("create table product(proId number,proName varchar2(20),proPrice number)");
		}
		catch( SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public int saveProduct(Products product)
	{
		int result=0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("insert into product values(?,?,?)");)
		{
			preparedStatement.setInt(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setFloat(3,product.getProPrice());
			result=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public Products getProductById(int id)
	{
		Products product=null;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from product where proId=?");)
		{
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				product=new Products();
				product.setProId(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getFloat(3));
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	}
	
	public List<Products> getAllProducts()
	{
		List<Products> pro=new ArrayList<Products>();
		try(Connection connection=DbConnection.createConnection();
			Statement statement=connection.createStatement();)
		{
			ResultSet resultSet=statement.executeQuery("select * from product");
			while(resultSet.next())
			{
				Products product=new Products();
				product.setProId(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getFloat(3));
				pro.add(product);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return pro;
	}
	public int updateByPrice(int priceRange,int IncrementValue)
	{
		int count=0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("update product set proPrice=proPrice+? where proPrice>?");)
		{
			preparedStatement.setInt(1, IncrementValue);
			preparedStatement.setInt(2, priceRange);
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	public int deleteById(int id)
	{
		int count=0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from product where proId=?");)
		{
			preparedStatement.setInt(1, id);
			count = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	public int deleteByPrice(float price)
	{
		int count=0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from product where proPrice>=?");)
		{
			preparedStatement.setFloat(1,price );
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
		
	public int dropTable()
	{
		int result=0;
		try(Connection connection=DbConnection.createConnection();
				Statement statement=connection.createStatement();)
		{
			result=statement.executeUpdate("drop table product");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
