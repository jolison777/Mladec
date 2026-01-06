<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Operation Successful</title>
<style>
    body { font-family: Arial, sans-serif; margin: 40px; }
    h2 { color: #27ae60; }
    p { font-size: 16px; }
    a { text-decoration: none; color: #2980b9; }
    a:hover { color: #e74c3c; }
</style>
</head>
<body>
    <h2>✅ Operation Successful</h2>

    <!-- If an employee object is passed -->
    <c:if test="${not empty employee}">
        <p>Employee Details:</p>
        <ul>
            <li>ID: ${employee.id}</li>
            <li>Name: ${employee.name}</li>
            <li>Department: ${employee.department}</li>
            <li>Salary: ${employee.salary}</li>
        </ul>
    </c:if>

    <!-- If a message is passed -->
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <p><a href="index.jsp">⬅️ Back to Home</a></p>
</body>
</html>
