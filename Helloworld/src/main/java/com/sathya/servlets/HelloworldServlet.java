package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloworldServlet
 */
@WebServlet("/Anvesh")
public class HelloworldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<h1>Welcome to java Full Stack<h1>");
		writer.println("<h2>I am Anvesh<h2>");
		writer.println("<h3>This is the first servlet app<h3>");
		writer.println("<h4>classes teached by Ratan sir<>h4");
		writer.println("</html>");
	}

}
