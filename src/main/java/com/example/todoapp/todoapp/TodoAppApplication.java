package com.example.todoapp.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class TodoAppApplication {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "123123"); Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT count(*) FROM pg_database WHERE datname = 'tododb'");
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count <= 0) {
                statement.executeUpdate("CREATE DATABASE tododb");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        SpringApplication.run(TodoAppApplication.class, args);
    }

}
