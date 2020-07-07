package com.example.shelter.db;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

import com.example.shelter.animal.Dog;
import com.example.shelter.ArrayAndCollectionsExample;
import com.example.shelter.animal.DogStatus;
import java.time.LocalDateTime;


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
    public static void addNewDogs(String name, DogStatus status, LocalDateTime visit_time) {
        try (
                Connection connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into dogs (name,status,visit_time) values (?,?,?);")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, status.name());
            preparedStatement.setTime(3, visit_time);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}