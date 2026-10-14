package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Loginservletsession extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Tell the browser to render HTML
        response.setContentType("text/html");

        String employeeName = request.getParameter("employeeName");

        // Create or fetch session and store the user name
        HttpSession session = request.getSession();
        session.setAttribute("studentname", employeeName);

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html><body>");
        out.println("<h1>User login successfully</h1>");
        out.println("<h2>Welcome Codegnan</h2>");
        out.println("<h2>Employee Name: " + employeeName + "</h2>");
        out.println("<br>");
        out.println("<a href='welcome'>Go to Welcome Page</a>");
        out.println("</body></html>");
    }
}