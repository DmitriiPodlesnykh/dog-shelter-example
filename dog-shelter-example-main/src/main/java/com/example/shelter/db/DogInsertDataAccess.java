package com.example.shelter.db;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import com.example.shelter.animal.Dog;
import com.example.shelter.animal.DogStatus;


public class DogInsertDataAccess {
    public static void addNewDogByName(String name) {
        Connection connection = null;
        Statement statement = null;
        try (
                Connection connection1 = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into dogs (name) values (?);")) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Добавить всех собак из коллекции в БД
     * <p>
     * --@param dogs собаки
     */
    public static void addNewDog(String name, DogStatus status, LocalDateTime visit_time) {

        try (
                Connection connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into dogs (name,status,visit_time) values (?,?,?);")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, status.name());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(visit_time));

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

        for (Dog dog : dogs) {

            addNewDog(dog.name, dog.dogStatus, dog.visitTime);
        }
    }
}