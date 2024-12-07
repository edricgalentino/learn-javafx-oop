package com.ecommerce.javafx2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    public static void insertUser(String username, String password, String role) throws SQLException {
        String query = "INSERT INTO user (username, password, role) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Failed to insert user", e);
        }
    }

    public static void updateUser(String id, String username, String password, String role) throws SQLException {
        String query = "UPDATE user SET username = ?, password = ?, role = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            preparedStatement.setString(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Failed to update user", e);
        }
    }

    public static void deleteUser(String id) throws SQLException {
        String query = "DELETE FROM user WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Failed to delete user", e);
        }
    }

    public static void findUser(String username) throws SQLException {
        String query = "SELECT * FROM user WHERE username = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("Failed to find user", e);
        }
    }
}
