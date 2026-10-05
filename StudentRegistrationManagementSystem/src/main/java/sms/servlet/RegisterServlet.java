package sms.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASS = "root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String course = req.getParameter("course");
        String[] skillsArr = req.getParameterValues("skills");
        String skills = (skillsArr != null) ? String.join(", ", skillsArr) : "None";
        String address = req.getParameter("address");

        String sql = "INSERT INTO student (name, age, email, password, gender, course, skills, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setString(3, email);
                ps.setString(4, password);
                ps.setString(5, gender);
                ps.setString(6, course);
                ps.setString(7, skills);
                ps.setString(8, address);

                int result = ps.executeUpdate();
                out.println(result > 0 ? "<h3>Registration Successful!</h3>" : "<h3>Registration Failed.</h3>");
            }
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
        out.println("<a href='index.html'>Home Page</a>");
    }
}