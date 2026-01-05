package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	
	String usr=request.getParameter("user");
	String pas=request.getParameter("pwd");
	
	HttpSession session=request.getSession();
	session.setAttribute("info", usr);
	ServletContext ctx=getServletContext();
	int t=(int)ctx.getAttribute("tusers");
	int c=(int)ctx.getAttribute("cusers");
	
	out.println("<h3>Total Users:"+t+"</h3>");
	out.println("<h3>Current Users:"+c+"</h3>");
	
	
	/*
	 * if(usr.equals("admin") && pas.equals("java")) { RequestDispatcher
	 * rd=request.getRequestDispatcher("home.html"); rd.forward(request, response);
	 * } else {
	 * out.print("<center><font colr= 'red'> invalid credentials</font></center> ");
	 * RequestDispatcher rd=request.getRequestDispatcher("login.html");
	 * rd.include(request, response); }
	 */
	
	}

}
