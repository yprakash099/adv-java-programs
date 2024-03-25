package com.sathy.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updateproId = request.getParameter("proId");
		String updateproName = request.getParameter("proName");
		double updateproPrice = Double.parseDouble(request.getParameter("proPrice"));
		String updateproBrand = request.getParameter("proBrand");
		String updateproMadeIn = request.getParameter("proMadeIn");
		Date updateProManfDate = Date.valueOf(request.getParameter("ProManfDate"));
		Date updateProExpDate= Date.valueOf(request.getParameter("ProExpDate"));
		
		Product product=new Product();
		product.setProId(updateproId);
		product.setProName(updateproName);
		product.setProPrice(updateproPrice);
		product.setProBrand(updateproBrand);
		product.setProMadeIn(updateproMadeIn);
		product.setProManfDate(updateProManfDate);
		product.setProExpDate(updateProExpDate);
//*****************************************************************************************	
		Part part = request.getPart("newproImage");
		if(part !=null && part.getSize()>0)
		{
			InputStream inputStream=part.getInputStream();
			byte[] newproImage = IOUtils.toByteArray(inputStream);
			product.setProImage(newproImage);
		}
		else
		{
			String s=request.getParameter("existingImage");
			byte[] oldImage= Base64.getDecoder().decode(s);
			product.setProImage(oldImage);
		}
//****************************************************************************************		
		Part part2 = request.getPart("newproAudio");
		if(part2!=null && part2.getSize()>0)
		{
			InputStream inputStream2 = part2.getInputStream();
			byte[] newproAudio = IOUtils.toByteArray(inputStream2);
			product.setProAudio(newproAudio);
		}
		else
		{
			String s1 = request.getParameter("existingAudio");
			byte[] oldAudio = Base64.getDecoder().decode(s1);
			product.setProAudio(oldAudio);
		}
//******************************************************************************************		
		Part part3 = request.getPart("newproVideo");
		if(part3!=null && part3.getSize()>0)
		{
			InputStream inputStream3 = part3.getInputStream();
			byte[] newproVideo = IOUtils.toByteArray(inputStream3);
			product.setProVideo(newproVideo);
		}
		else
		{
			String s2 = request.getParameter("existingVideo");
			byte[] oldVideo = Base64.getDecoder().decode(s2);
			product.setProVideo(oldVideo);
		}
//*********************************************************************************************		
		ProductDao dao = new ProductDao();
		int result = dao.updateById(product);
		if(result == 1)
		{
			request.setAttribute("updateResult", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("Data Updation fail check once.."+result);
			RequestDispatcher dispatcher =request.getRequestDispatcher("Add-product.html");
			dispatcher.include(request, response);
		}
		
	}

}
