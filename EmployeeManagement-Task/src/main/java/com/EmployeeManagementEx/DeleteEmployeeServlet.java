package com.EmployeeManagementEx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    private EmployeeDao dao = new EmployeeDaoImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.deleteEmployee(id);
        req.setAttribute("message", "Employee deleted successfully!");
        req.getRequestDispatcher("success.jsp").forward(req, resp);
    }
}
