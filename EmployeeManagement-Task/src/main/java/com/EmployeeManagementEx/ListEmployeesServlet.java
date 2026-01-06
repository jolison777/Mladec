package com.EmployeeManagementEx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/listEmployees")
public class ListEmployeesServlet extends HttpServlet {
    private EmployeeDao dao = new EmployeeDaoImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("employees", dao.getAllEmployees());
        req.getRequestDispatcher("listEmployees.jsp").forward(req, resp);
    }
}
