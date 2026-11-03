<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cgjsp.employee"%>
<!DOCTYPE html>
<html>

<body>

<jsp:useBean id="emp" class="cgjsp.employee" scope="request"/>
<jsp:setProperty property="*" name="emp"/>
<%-- <jsp:setProperty property="ename" name="emp"/> 
<jsp:setProperty property="age" name="emp"/> --%>

<h2>Employee Details</h2>
<h3>EmpID: <jsp:getProperty property="eid" name="emp"/></h3>
<h3>EmpName: <jsp:getProperty property="ename" name="emp"/></h3>
<h3>EmpAge: <jsp:getProperty property="age" name="emp"/></h3>


</body>
</html>