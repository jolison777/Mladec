<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Data</title>
</head>
<body>
<h1>Employee Data</h1>
<jsp:useBean id="emp" class="com.test.EmployeePojo" scope="request"/>
<jsp:setProperty property="*" name="emp"/>

ID: <jsp:getProperty property="id" name="emp"/><br>
Name: <jsp:getProperty property="name" name="emp"/><br>
Company: <jsp:getProperty property="cmp" name="emp"/>
</body>
</html>