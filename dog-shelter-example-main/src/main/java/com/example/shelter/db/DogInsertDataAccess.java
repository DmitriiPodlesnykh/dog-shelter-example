package com.example.shelter.db;

import java.sql.*;

public class DogInsertDataAccess {

    public static void addNewDog(String name) {
        try (
                Connection connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into dogs (name) values (?);")) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
