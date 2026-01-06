package com.EmployeeManagementEx;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    private EmployeeDao dao = new EmployeeDaoImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String dept = req.getParameter("department");
        double salary = Double.parseDouble(req.getParameter("salary"));

        Employee emp = dao.addEmployee(new Employee(id, name, dept, salary));
        req.setAttribute("employee", emp);
        req.getRequestDispatcher("success.jsp").forward(req, resp);
    }
}
