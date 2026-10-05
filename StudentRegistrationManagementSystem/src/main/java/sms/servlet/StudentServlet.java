package sms.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASS = "root"; // Update to your MySQL password

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String action = req.getParameter("action");

        if (action == null) action = "register";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            if ("register".equals(action)) {
                String name = req.getParameter("name");
                int age = Integer.parseInt(req.getParameter("age"));
                String email = req.getParameter("email");
                String pwd = req.getParameter("password");
                String gender = req.getParameter("gender");
                String course = req.getParameter("course");
                String[] skillsArr = req.getParameterValues("skills");
                String skills = (skillsArr != null) ? String.join(", ", skillsArr) : "";
                String address = req.getParameter("address");

                String sql = "INSERT INTO student (name, age, email, password, gender, course, skills, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setString(3, email);
                ps.setString(4, pwd);
                ps.setString(5, gender);
                ps.setString(6, course);
                ps.setString(7, skills);
                ps.setString(8, address);

                int rows = ps.executeUpdate();
                out.println(rows > 0 ? "<h3>Registration Successful!</h3>" : "<h3>Registration Failed.</h3>");

            } else if ("list".equals(action)) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM student");
                renderTable(out, rs);

            } else if ("search".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM student WHERE id = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                renderTable(out, rs);

            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE id = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
                out.println("<h3>Student Deleted Successfully!</h3>");
            }
        } catch (SQLException e) {
            e.printStackTrace(out);
        }
        out.println("<br><a href='index.html'>Back to Home</a> | <a href='student?action=list'>View All</a>");
    }

    private void renderTable(PrintWriter out, ResultSet rs) throws SQLException {
        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Action</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("name") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("course") + "</td>");
            out.println("<td><a href='student?action=delete&id=" + rs.getInt("id") + "'>Delete</a></td></tr>");
        }
        out.println("</table>");
    }
}