package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userlogin")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();

	    String uname = "root";
	    String pwd = "root";

	    String uname1 = req.getParameter("username");
	    String pword1 = req.getParameter("password");

	    // If inputs are missing, redirect back to the HTML form
	    if (uname1 == null || pword1 == null) {
	        res.sendRedirect("login.html"); // Replace with your HTML filename
	        return;
	    }

	    if (uname.equals(uname1.trim()) && pwd.equals(pword1.trim())) {
	        out.println("<h1>User login successfully</h1>");
	    } else {
	        out.println("<h1>User login failed!</h1>");
	    }
	}
}