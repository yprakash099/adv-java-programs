package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//read the requested data.
		
		int num1=Integer.parseInt(request.getParameter("first"));
		int num2=Integer.parseInt(request.getParameter("second"));
		String operation = request.getParameter("operation");
		
		//process the data.
		
		int result=0;
		switch (operation) {
		case "+":result=num1+num2;
				break;
		case "-":result=num1-num2;
				break;
		case "*":result=num1*num2;
				break;
		case "/":result=num1/num2;
				break;
		case "%":result=num1%num2;
				break;
		
		}
		
		//render the response
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>"+"your results.."+"</h1>");
		writer.println("<p>"+"your First Number : "+num1+"</p>");
		writer.println("<p>"+"your Second Number : "+num2+"</p>");
		writer.println("<p>"+"your Operation : "+operation+"</p>");
		writer.println("Your result is: "+result);
		writer.println("</body>");
		writer.println("</html>");

	}


}
