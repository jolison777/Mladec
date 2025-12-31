package com.test.JDBCEXAMPLE1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCNEWEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/mladec";
        String user = "root";
        String pass = "root@39";

        try {
            // Load driver (optional in modern JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            try (Connection con = DriverManager.getConnection(url, user, pass);
                 Statement stmt = con.createStatement()) {

                // Execute query
				
				  stmt.
				  execute("CREATE TABLE Flayers (f_id INT, f_name VARCHAR(50), f_price INT)");
				  
				  stmt.addBatch("INSERT INTO Flayers VALUES (1, 'Messi', 1000)");
				  stmt.addBatch("INSERT INTO Flayers VALUES (2, 'Ronaldo', 950)");
				  stmt.addBatch("INSERT INTO Flayers VALUES (3, 'Neymar', 850)");
				  stmt.addBatch("INSERT INTO Flayers VALUES (4, 'Mbappe', 900)");
				  stmt.addBatch("INSERT INTO Flayers VALUES (5, 'Lewandowski', 800)");
				  stmt.addBatch("update Flayers set f_price=1100 where f_id=2");
				  stmt.addBatch("delete from Flayers where f_id=1"); stmt.executeBatch();
				 
                
                ResultSet rs=stmt.executeQuery("select * from Flayers ");
                while(rs.next()) {
                	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                
	}

}
