package com.test.JDBCEXAMPLE1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCCONN {

    public static void main(String[] args) {
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
               // stmt.execute("CREATE TABLE book1 (b_id INT, b_name VARCHAR(50), b_price INT)");
                
                //Insert query
                String sql="insert into book1 values(1,'JAVA',250)";
               //stmt.execute(sql);
                stmt.addBatch("insert into book1 values(2,'Spring',350)");
                stmt.addBatch("insert into book1 values(3,'anguler',500)");
                stmt.addBatch("update book1 set b_name ='react' where b_id =3");
                stmt.addBatch("delete from book1 where b_id=3");
                stmt.executeBatch();
                
                //Storing in result set
                sql="select * from book1";
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()) {
                	System.out.println("ID :"+rs.getInt(1)+" Name :"+rs.getString(2)+" Price: "+rs.getInt(3));
                }
                
                
    
                System.out.println("Done");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
