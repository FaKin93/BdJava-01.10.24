package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveElementById {
    public static void main(String[] args) {
        // Database connection settings
        String url = "jdbc:sqlserver://localhost:1433;database=Library;encrypt=true;trustServerCertificate=true;";
        String username = "libraryUser";
        String password = "123456";

        // Create a connection to the database
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Create a prepared statement to retrieve an element by ID
            String query = "SELECT * FROM Book WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                // Set the ID value
                pstmt.setInt(1, Integer.parseInt(args[0]));

                // Execute the query
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // Retrieve the values from the result set
                        String column1 = rs.getString("title");
                        String column2 = rs.getString("author");
                        java.sql.Date column3 = rs.getDate("year");

                        System.out.println("Element found: " + column1 + ", " + column2 + ", " + column3);
                    } else {
                        System.out.println("Element not found");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving element: " + e.getMessage());
        }
    }
}