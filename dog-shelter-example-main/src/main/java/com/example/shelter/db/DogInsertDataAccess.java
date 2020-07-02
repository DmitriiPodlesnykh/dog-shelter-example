package com.example.shelter.db;

import java.sql.*;
import java.util.List;

import com.example.shelter.animal.Dog;

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

    /**
     * Добавить всех собак из коллекции в БД
     *
     * @param dogs собаки
     */
    public static void addNewDogs(List<Dog> dogs) {

    }
}
