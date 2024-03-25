package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NumberlistServlet")
public class NumberlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//read the requested data.
		
		int num1 =Integer.parseInt(request.getParameter("start"));
		int num2=Integer.parseInt(request.getParameter("end"));
		String operation =request.getParameter("operation");
		
		//process the data
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		switch(operation)
		{
		case "Even" : for(int i=num1;i<=num2;i++)
		{
			if(i%2==0)
			{
				al.add(i);
			}
		}
		break;
		case "Odd" : 
			for(int i=num1;i<=num2;i++)
			{
				if(i%2!=0)
				{
					al.add(i);
				}
			}
			break;
		case "Prime" : 
			for(int i=num1;i<=num2;i++)
		
			{
				int c=0;
				for(int j=1;j<=i;j++)
				{
					if(i%j==0)
					{
						c++;
					}
				}
				if(c==2)
				{
					al.add(i);
				}
			}
			break;
			case "Strong" : for(int i=num1;i<=num2;i++)
			{
				int temp=i,sum=0;
				while(temp>0)
				{
					int temp1=temp%10;
					int fact=1;
					for(int j=1;j<=temp1;j++)
					{
						fact=fact*j;
					}
					sum=sum+fact;
					temp=temp/10;
				}
				if(sum==i)
				{
					al.add(i);
				}
			}
			break;
		
}
		//render the response.
		 
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("Your Start Number :"+num1+"<br>");

		writer.println("Your End Number :"+num2+"<br>");
		
		writer.println("Your operation :"+operation+"<br>");

		writer.println("Your result is :"+al);

		writer.println("</html>");

		
		
	}
}
