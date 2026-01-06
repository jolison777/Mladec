<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>
<style>
    body { font-family: Arial, sans-serif; margin: 40px; }
    h2 { color: #2c3e50; }
    table { border-collapse: collapse; width: 80%; margin-top: 20px; }
    th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
    th { background-color: #f2f2f2; }
    tr:hover { background-color: #f9f9f9; }
    a { text-decoration: none; color: #2980b9; }
    a:hover { color: #e74c3c; }
</style>
</head>
<body>
    <h2>📋 Employee List</h2>

    <%
        java.util.List<com.EmployeeManagementEx.Employee> employees =
            (java.util.List<com.EmployeeManagementEx.Employee>) request.getAttribute("employees");

        if (employees == null || employees.isEmpty()) {
    %>
        <p>No employees found.</p>
    <%
        } else {
    %>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Department</th>
                <th>Salary</th>
            </tr>
            <%
                for (com.EmployeeManagementEx.Employee emp : employees) {
            %>
                <tr>
                    <td><%= emp.getId() %></td>
                    <td><%= emp.getName() %></td>
                    <td><%= emp.getDepartment() %></td>
                    <td><%= emp.getSalary() %></td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>

    <p><a href="index.jsp">⬅️ Back to Home</a></p>
</body>
</html>
