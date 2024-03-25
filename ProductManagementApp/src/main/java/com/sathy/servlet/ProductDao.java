package com.sathy.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ProductDao {
	public int save(Product product) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int saveresult = 0;
		try {
			connection = DbUtilities.createConnection();
			preparedStatement = connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			preparedStatement.setDate(6, (Date) product.getProManfDate());
			preparedStatement.setDate(7, (Date) product.getProExpDate());
			preparedStatement.setBytes(8, product.getProImage());
			preparedStatement.setBytes(9, product.getProAudio());
			preparedStatement.setBytes(10, product.getProVideo());

			saveresult = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return saveresult;
	}
	public List<Product> findAll()
	{
		List<Product> pro=new ArrayList<Product>();
		try(Connection connection=DbUtilities.createConnection();
			Statement statement=connection.createStatement();)
		{
			ResultSet resultSet=statement.executeQuery("select * from product_data");
			while(resultSet.next())
			{
				Product product=new Product();
				product.setProId(resultSet.getString(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(Double.parseDouble(resultSet.getString(3)));
				product.setProBrand(resultSet.getString(4));
				product.setProMadeIn(resultSet.getString(5));
				product.setProManfDate(resultSet.getDate(6));
				product.setProExpDate(resultSet.getDate(7));
				product.setProImage(resultSet.getBytes(8));
				product.setProAudio(resultSet.getBytes(9));
				product.setProVideo(resultSet.getBytes(10));
				pro.add(product);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return pro;
	}
	
	public int deleteById(String proId)
	{
		int result=0;
		try(Connection connection=DbUtilities.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from product_data where proId=?");)
		{
			preparedStatement.setString(1,proId );
			result=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public Product findById(String proId)
	{
		Product product=null;
		try(Connection connection=DbUtilities.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from product_data where proId=?");)
		{
			preparedStatement.setString(1, proId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				product=new Product();
				product.setProId(resultSet.getString(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
				product.setProBrand(resultSet.getString(4));
				product.setProMadeIn(resultSet.getString(5));
				product.setProManfDate(resultSet.getDate(6));
				product.setProExpDate(resultSet.getDate(7));
				product.setProImage(resultSet.getBytes(8));
				product.setProAudio(resultSet.getBytes(9));
				product.setProVideo(resultSet.getBytes(10));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return product;
}
	public int  updateById(Product product)
	{
		String sql="update product_data set proName=?, proPrice=?, proBrand=?, proMadeIn=?, ProManfDate=?,ProExpDate=?,proImage=?, proAudio=?, proVideo=? where proId=?";
		int updateresult=0;
		try(Connection connection=DbUtilities.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(sql);)
		{
			preparedStatement.setString(1, product.getProName());
			preparedStatement.setDouble(2, product.getProPrice());
			preparedStatement.setString(3, product.getProBrand());
			preparedStatement.setString(4, product.getProMadeIn());
			preparedStatement.setDate (5, (Date)product.getProManfDate());
			preparedStatement.setDate (6, (Date)product.getProExpDate());
			preparedStatement.setBytes(7, product.getProImage());
			preparedStatement.setBytes(8, product.getProAudio());
			preparedStatement.setBytes(9, product.getProVideo());
			preparedStatement.setString(10, product.getProId());
			updateresult=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return updateresult;
	}
}
