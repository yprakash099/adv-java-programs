package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//read the requested data.
		int empid=Integer.parseInt(request.getParameter("empId"));
		String empname=request.getParameter("empName");
		double empsal=Double.parseDouble(request.getParameter("empSalary"));
		
		//process the data
		double hra=0,da=0,pf=0,gross=0;
		if(empsal>=50000)
		{
			hra=empsal*30/100;
			da=empsal*10/100;
			pf=empsal*6/100;
			gross=empsal+hra+da-pf;
		}
		else if(empsal<50000 && empsal>25000)
		{
			hra=empsal*20/100;
			da=empsal*5/100;
			pf=empsal*3/100;
			gross=empsal+hra+da-pf;
		}
		else
		{
			hra=empsal*10/100;
			da=empsal*3/100;
			pf=empsal*2/100;
			gross=empsal+hra+da-pf;
		}
		
		//render the response
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("Employee Id :"+empid+"<br>");
		writer.println("Employee Name :"+empname+"<br>");
		writer.println("Employee BasicSalary :"+empsal+"<br>");
		writer.println("HRA Amount :"+hra+"<br>");
		writer.println("DA Amount :"+da+"<br>");
		writer.println("PF Amount :"+pf+"<br>");
		writer.println("Gross Salary :"+gross);
		writer.println("</html>");

		
		
	}

}
