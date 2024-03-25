package com.sathya.tech;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FullnameServlet
 */
@WebServlet("/FullnameServlet")
public class FullnameServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		String mname = request.getParameter("middlename");
		String lname = request.getParameter("lastname");
		
		PrintWriter writer = response.getWriter();
		writer.println(fname+" "+mname+""+lname);
	}


}
