package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Read the requested data.
		int proid=Integer.parseInt(request.getParameter("proId"));
		String proname=request.getParameter("proName");
		double proprice=Double.parseDouble(request.getParameter("proPrice"));
		int proquantity = Integer.parseInt(request.getParameter("proQuantity"));
		
		//process the data
		double totalbill=proprice*proquantity;
		double discount=0;
		double d=0;
		if(totalbill<1000)
		{
			discount=0;
			d=totalbill;
			
		}
		else if(totalbill>1000 && totalbill<5000)
		{
			discount=totalbill*5/100;
			double tb=totalbill-discount;
		 d=tb;
			
		}
		else if(totalbill>5000 && totalbill<10000)
		{
			discount=totalbill*10/100;
			double tb=totalbill-discount;
			 d=tb;
			
		}
		else
		{
			discount=totalbill*15/100;
			double tb=totalbill-discount;
			 d=tb;
		}
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("Product Id :"+proid+"<br>");
		writer.println("Product Name :"+proname+"<br>");
		writer.println("Product price :"+proprice+"<br>");
		writer.println("Product quantity:"+proquantity+"<br>");
		writer.println("Product totalbill :"+totalbill+"<br>");
		writer.println("Product discount:"+discount+"<br>");
		writer.println("Product netamout to pay :"+d);
		writer.println("</html>");
	}
}
