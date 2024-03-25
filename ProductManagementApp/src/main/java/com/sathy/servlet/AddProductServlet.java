package com.sathy.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the data from the form.
		
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadeIn=request.getParameter("proMadeIn");
		Date ProManfDate=Date.valueOf(request.getParameter("ProManfDate"));
		Date ProExpDate=Date.valueOf(request.getParameter("ProExpDate"));
		Part part=request.getPart("proImage");
		InputStream inputStream =part.getInputStream();
		
		//conversion of inputstream into byte[].
		byte[] proImage = IOUtils.toByteArray(inputStream);
		
		Part part2=request.getPart("proAudio");
		InputStream inputStream2=part2.getInputStream();
		byte[] proAudio = IOUtils.toByteArray(inputStream2);
		
		Part part3=request.getPart("proVideo");
		InputStream inputStream3=part3.getInputStream();
		byte[] proVideo = IOUtils.toByteArray(inputStream3);
		
		
		//using the above detail create the product object.
		
		Product product=new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadeIn(proMadeIn);
		product.setProManfDate(ProManfDate);
		product.setProExpDate(ProExpDate);
		product.setProImage(proImage);
		product.setProAudio(proAudio);
		product.setProVideo(proVideo);
		
		ProductDao productDao=new ProductDao();
		int result=productDao.save(product);
		
		if(result == 1)
		{
			request.setAttribute("saveResult", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data insertion fail check once.."+result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Add-product.html");
			dispatcher.include(request, response);
		}
	}

}
