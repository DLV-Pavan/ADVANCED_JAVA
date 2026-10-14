package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve existing session without creating a new one
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("empid") != null) {
            String empid = (String) session.getAttribute("empid");
            
            out.println("<h1>Employee login successfully</h1><br>");
            out.println("<h1>Welcome " + empid + "</h1>");
            out.println("<a href='EmployeeLogout'>Logout</a>");
        } else {
            out.println("<h3>Please login first</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("elogin.html");
            rd.include(request, response);
        }
    }
}