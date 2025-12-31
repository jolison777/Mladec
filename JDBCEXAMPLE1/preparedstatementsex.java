package com.test.JDBCEXAMPLE1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class preparedstatementsex {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mladec";
        String user = "root";
        String pass = "root@39";

        // Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        Connection con = DriverManager.getConnection(url, user, pass);

        // Insert
        String sql1 = "INSERT INTO book1 VALUES (?,?,?)";
        PreparedStatement pst1 = con.prepareStatement(sql1);
        pst1.setInt(1, 3);
        pst1.setString(2, "python");
        pst1.setInt(3, 100);
        pst1.addBatch();
        pst1.executeBatch();

        // Update
        String sql2 = "UPDATE book1 SET b_name=? WHERE b_id=?";
        PreparedStatement pst2 = con.prepareStatement(sql2);
        pst2.setString(1, "Python Updated");
        pst2.setInt(2, 3);
        pst2.addBatch();
        pst2.executeBatch();

        // Select
        String sql3 = "SELECT * FROM book1";
        PreparedStatement pst3 = con.prepareStatement(sql3);
        ResultSet rs = pst3.executeQuery();
        ResultSetMetaData rsd=rs.getMetaData();
        System.out.println(rsd.getColumnClassName(1));
        System.out.println(rsd.getColumnCount());
        System.out.println(rsd.getColumnClassName(1));
     

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
        }

        // Close resources
        rs.close();
        pst1.close();
        pst2.close();
        pst3.close();
        con.close();
    }
}
