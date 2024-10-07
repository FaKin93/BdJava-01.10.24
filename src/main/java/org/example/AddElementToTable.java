package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddElementToTable  {
    public static void main(String[] args) {
        // Database connection settings
        String url = "jdbc:sqlserver://localhost:1433;database=Library;encrypt=true;trustServerCertificate=true;";
        String username = "libraryUser";
        String password = "123456";

        // Create a connection to the database
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Create a prepared statement to insert a new element
            String query = "INSERT INTO Book (title, author, year) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                String data = args[2];
                System.out.println(data);
                pstmt.setString(1, args[0]);
                pstmt.setString(2, args[1]);
                pstmt.setDate(3, java.sql.Date.valueOf(args[2]));

                // Execute the query
                pstmt.executeUpdate();
                System.out.println("Element added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error adding element: " + e.getMessage());
        }
    }
}
