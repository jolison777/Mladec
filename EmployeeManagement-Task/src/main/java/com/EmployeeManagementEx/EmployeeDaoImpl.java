package com.EmployeeManagementEx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final String URL = "jdbc:mysql://localhost:3306/mladec?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root@39";

    // Constructor ensures table exists
    public EmployeeDaoImpl() {
        try {
            // Explicitly load driver (important for Tomcat)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found!", e);
        }
        createTableIfNotExists();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    /** Create table if not exists **/
    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                     "id INT PRIMARY KEY, " +
                     "name VARCHAR(100), " +
                     "department VARCHAR(100), " +
                     "salary DOUBLE)";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'employees' checked/created successfully.");
        } catch (SQLException e) {
            throw new RuntimeException("Error creating table", e);
        }
    }

    @Override
    public Employee addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDepartment());
            ps.setDouble(4, emp.getSalary());
            ps.executeUpdate();
            return emp;
        } catch (SQLException e) {
            throw new RuntimeException("Error adding employee", e);
        }
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                return emp;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating employee", e);
        }
        return null;
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting employee", e);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                );
                list.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching employees", e);
        }
        return list;
    }
}
