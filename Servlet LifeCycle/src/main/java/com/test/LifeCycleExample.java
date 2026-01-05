package com.test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/LifeCycleExample")
public class LifeCycleExample extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
 
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Processes request and response");
	}
	public void doGet(ServletRequest request, ServletResponse response) {
		
	}
	

}
