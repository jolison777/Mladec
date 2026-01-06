package com.EmployeeManagementEx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
    private EmployeeDao dao = new EmployeeDaoImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String dept = req.getParameter("department");
        double salary = Double.parseDouble(req.getParameter("salary"));

        Employee updated = dao.updateEmployee(new Employee(id, name, dept, salary));
        req.setAttribute("employee", updated);
        req.getRequestDispatcher("success.jsp").forward(req, resp);
    }
}
