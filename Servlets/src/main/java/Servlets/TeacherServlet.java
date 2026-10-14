package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TeacherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		ServletContext ctx = getServletContext();
		String institute = ctx.getInitParameter("Institute");
		
		ServletConfig config = getServletConfig();
		String logintype = config.getInitParameter("logintype");
		
		out.println("<h1>logintype:</h1>" + logintype + "<br>");
		out.println("<h1>institutename:</h1>" + institute + "<br>");
	}
}