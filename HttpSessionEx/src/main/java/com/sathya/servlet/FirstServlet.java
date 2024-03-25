package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		int age = Integer.parseInt( request.getParameter("age"));
		
		HttpSession session=request.getSession();
		
		session.setAttribute("username", username );
		session.setAttribute("age", age);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("Form2.html");
		dispatcher.forward(request, response);
		
		
	}

}
