package com.test.JDBCEXAMPLE1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementex {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 String url = "jdbc:mysql://localhost:3306/mladec";
	        String user = "root";
	        String pass = "root@39";

	        // Load driver
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Establish connection
	        Connection con = DriverManager.getConnection(url, user, pass);
	        CallableStatement cst=con.prepareCall("{call readData}");
	        ResultSet rs=cst.executeQuery();
	        while(rs.next()) {
	        	System.out.println("ID : "+rs.getInt(1)+" Name : "+rs.getString(2)+" Price :"+rs.getInt(3));
	        }

	}

}
