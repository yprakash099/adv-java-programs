package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		Long mobile= Long.parseLong(request.getParameter("mobile"));
		
		HttpSession session=request.getSession(false);
		
		response.setContentType("text/html");
		
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor:skyblue>");
		writer.println("<pre>");
		writer.println("Your UserName : "+session.getAttribute("username")+"<br><br>");
		writer.println("Your Age : "+session.getAttribute("age")+"<br><br>");
		writer.println("Your Qualification : "+session.getAttribute("qualification")+"<br><br>");
		writer.println("Your Designation : "+session.getAttribute("designation")+"<br><br>");
		writer.println("your Email : "+email+"<br><br>");
		writer.println("Your Mobile : "+mobile+"<br><br>");
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
