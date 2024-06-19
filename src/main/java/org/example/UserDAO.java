package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final String url = "jdbc:mysql://localhost:3306/jeff_db";
    private final String user = "jeff";
    private final String password = "123123..";

    public void insertUser(String name, String email) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password); // try with resource 구문이라고 합니다. 여기선 논외!
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        }
    }

    public ResultSet getUsers() throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users")) {
            return preparedStatement.executeQuery();
        }
    }

    public void updateUserEmail(String name, String newEmail) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET email = ? WHERE name = ?")) {
            preparedStatement.setString(1, newEmail);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteUser(String name) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE name = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
    }
}