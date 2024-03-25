package com.sathya.tech;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//read the form data
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//process the data
		
		String status;
		if(username.equals("Anvesh") && password.equals("Anvesh@123"))
		{
			status="Login Successfull..";
		}
		else
		{
			status = "Login fail..";
		}
		
		//render the response
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>Login Status..</h1>"+status);
		writer.println("</html>");
		
	}

	

}
