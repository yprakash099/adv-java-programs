package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Read the requested data from request object.
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		long mblno = Long.parseLong(request.getParameter("mobile"));
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String[] quals = request.getParameterValues("qualification");
		String country = request.getParameter("country");
		String[] langs=request.getParameterValues("languages");
		String comments=request.getParameter("comments");

		
		//process the data.
		
		String q=String.join(",", quals);
		String l=String.join("-", langs);
		
		//render the response.
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println(" User Name : "+username+"<br>");
		writer.println(" Password : "+password+"<br>");
		writer.println(" Mobile Number : "+mblno+"<br>");
		writer.println(" Email : "+email+"<br>");
		writer.println(" Gender : "+gender+"<br>");
		writer.println(" Date Of Birth : "+dob+"<br>");
		writer.println(" Qualification : "+q+"<br>");
		writer.println(" Country : "+country+"<br>");
		writer.println(" Selected Languages : "+l+"<br>");
		writer.println(" Comments : "+comments+"<br>");
		writer.println("</html>");


	}

}
