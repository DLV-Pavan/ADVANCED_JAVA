package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/welcome")
public class Welcomeservletsession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Tell the browser to render HTML
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        out.println("<!DOCTYPE html><html><body>");

        if (session != null && session.getAttribute("studentname") != null) {

            String sname = (String) session.getAttribute("studentname");

            out.println("<h1>User login successfully</h1>");
            out.println("<h1>Welcome Codegnan</h1>");
            out.println("<h1>" + sname + "</h1>");
            out.println("<br>");
            out.println("<a href='logout'>Logout</a>");

        } else {
            out.println("<h1>Please login first</h1>");
            out.println("<a href='login.html'>Go to Login Page</a>");
        }

        out.println("</body></html>");
    }
}