package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/simpleservlet")
public class SimpleServlet extends GenericServlet {
	
	public void init()
	{
		System.out.println("intialize the servlet");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		System.out.println("to called service method");
		
		PrintWriter out=res.getWriter();
		out.println("Welcome to Servlet program");
		
	}
	
	public void destroy()
	{
		System.out.println("To destroy the servlet objects");
	}
}
