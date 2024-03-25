package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		Long mobile= Long.parseLong(request.getParameter("mobile"));
		
		response.setContentType("text/html");
		Cookie[] cookies=request.getCookies();
		
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor:'skyblue'>");
		writer.println("<pre style='color:red'>");
		writer.println("Your UserName : "+cookies[0].getValue()+"<br>");
		writer.println("Your Age : "+cookies[1].getValue()+"<br>");
		writer.println("Your Qualification : "+cookies[2].getValue()+"<br>");
		writer.println("Your Designation : "+cookies[3].getValue()+"<br>");
		writer.println("your Email : "+email+"<br>");
		writer.println("Your Mobile : "+mobile+"<br>");
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
