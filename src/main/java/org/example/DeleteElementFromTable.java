package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteElementFromTable {
    public static void main(String[] args) {
        // Database connection settings
        String url = "jdbc:sqlserver://localhost:1433;database=Library;encrypt=true;trustServerCertificate=true;";
        String username = "libraryUser";
        String password = "123456";

        // Create a connection to the database
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Create a prepared statement to delete an element
            String query = "DELETE FROM Book WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                // Set the ID value
                pstmt.setInt(1, Integer.parseInt(args[0]));

                // Execute the query
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Element deleted successfully!");
                } else {
                    System.out.println("Element not found");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error deleting element: " + e.getMessage());
        }
    }
}
