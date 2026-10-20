<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.Date" %>
    
    <%!
    	int a=20;
    	int b=30;
    	public int add(){
    		return a+b;
    	}
    %>
    
    <%
    String s="pavan";
    String res="";
    if(s.length()%2==0){
    	res="even";
    } else {
    	res="odd";
    }
    %>
    
    <%
    
    String uname=request.getParameter("username");
    String password=request.getParameter("password");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Math Calculation</title>
</head>
<body>

	<h1>it is 1st jsp file</h1>
	<h2> a value is:<%=a%></h2>
	<h2> b value is:<%=b%></h2>
	<h2> Sum:<%=add()%></h2>
	<h2>Current date and time:<%=new Date() %></h2>
	<h2>result is:<%=res%></h2>
	<h2>username:<%=uname%></h2>
	<h2>password:<%=password%></h2>
	
</body>
</html>