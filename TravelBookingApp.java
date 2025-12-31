package com.travelApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TravelBookingApp {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/mladec"; // your DB name
        String user = "root";
        String pass = "root@39";

        // Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        Connection con = DriverManager.getConnection(url, user, pass);

        // --- Create table query ---
        String createTableSQL = "CREATE TABLE IF NOT EXISTS travel_booking (" +
                                "booking_id INT PRIMARY KEY AUTO_INCREMENT, " +
                                "customer_name VARCHAR(50), " +
                                "destination VARCHAR(50), " +
                                "price INT)";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(createTableSQL);
        System.out.println("Table 'travel_booking' created successfully!");

        // --- Insert booking ---
        String insertSQL = "INSERT INTO travel_booking (customer_name, destination, price) VALUES (?, ?, ?)";
        PreparedStatement insertStmt = con.prepareStatement(insertSQL);

        insertStmt.setString(1, "Alice");
        insertStmt.setString(2, "Paris");
        insertStmt.setInt(3, 50000);
        insertStmt.executeUpdate();

        insertStmt.setString(1, "Bob");
        insertStmt.setString(2, "London");
        insertStmt.setInt(3, 45000);
        insertStmt.executeUpdate();

        insertStmt.setString(1, "Charlie");
        insertStmt.setString(2, "New York");
        insertStmt.setInt(3, 70000);
        insertStmt.executeUpdate();

        System.out.println("Bookings inserted successfully!");

        // --- Retrieve bookings ---
        String selectSQL = "SELECT * FROM travel_booking";
        PreparedStatement selectStmt = con.prepareStatement(selectSQL);
        ResultSet rs = selectStmt.executeQuery();

        System.out.println("\n--- Travel Bookings ---");
        while (rs.next()) {
            System.out.println("Booking ID: " + rs.getInt("booking_id") +
                               ", Customer: " + rs.getString("customer_name") +
                               ", Destination: " + rs.getString("destination") +
                               ", Price: " + rs.getInt("price"));
        }

        // --- Close resources ---
        rs.close();
        insertStmt.close();
        selectStmt.close();
        stmt.close();
        con.close();
    }
}
