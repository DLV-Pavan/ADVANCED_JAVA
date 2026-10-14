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

@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Fetching parameters from the login form
        String empid = request.getParameter("empid");
        String emppass = request.getParameter("emppass");

        // Simple validation check (You can replace this with database checks later)
        if (empid != null && empid.equals("emp123") && emppass.equals("admin123")) {
            
            // Create a session and store employee details
            HttpSession session = request.getSession();
            session.setAttribute("empid", empid);

            // Forward to WelcomeServlet on successful login
            RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
            rd.forward(request, response);
            
        } else {
            // Display invalid credentials message and include the login page again
            out.println("<h3 style='color:red;'>Invalid credentials</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("elogin.html");
            rd.include(request, response);
        }
    }
}