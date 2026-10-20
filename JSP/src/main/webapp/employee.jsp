<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
    String checkName(String name) {
        if (name.length() % 2 == 0) {
            return "Even-length name";
        } else {
            return "Odd-length name";
        }
    }
%>

<%
    String empname = request.getParameter("empname");
    String department = request.getParameter("deptname");
    int sal = Integer.parseInt(request.getParameter("salary"));
    
    String result;
    if (sal >= 25000) {
        result = "High Salary";
    } else {
        result = "Low Salary";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Data</title>
</head>
<body>

    <h1>IT IS 2ND JSP FILE</h1>

    <h2>Employee Name: <%= empname %></h2>
    <h2>Name Check: <%= checkName(empname) %></h2>

    <h2>Department Name: <%= department %></h2>

    <h2>Salary: <%= sal %></h2>
    <h2>Salary Result: <%= result %></h2>

</body>
</html>
