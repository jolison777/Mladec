<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>
<style>
    body { font-family: Arial, sans-serif; margin: 40px; }
    h1 { color: #2c3e50; }
    ul { list-style-type: none; padding: 0; }
    li { margin: 10px 0; }
    a { text-decoration: none; color: #2980b9; font-size: 18px; }
    a:hover { color: #e74c3c; }
</style>
</head>
<body>
    <h1>Welcome to Employee Management System</h1>
    <p>Select an operation:</p>
    <ul>
        <li><a href="addEmployee.jsp">➕ Add Employee</a></li>
        <li><a href="updateEmployee.jsp">✏️ Update Employee</a></li>
        <li><a href="deleteEmployee.jsp">🗑️ Delete Employee</a></li>
        <li><a href="listEmployees">📋 View All Employees</a></li>
    </ul>
</body>
</html>
