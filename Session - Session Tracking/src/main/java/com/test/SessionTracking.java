package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/SessionTracking")
public class SessionTracking extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        HttpSession session = request.getSession();
        session.setAttribute("info", user);

        out.println("from main page : " + user);
        out.println("<a href='Logout'>Logout here</a>");

        out.close();
    }
}

