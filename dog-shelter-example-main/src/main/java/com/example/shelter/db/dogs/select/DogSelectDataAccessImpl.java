package com.example.shelter.db.dogs.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.shelter.animal.Dog;

import static com.example.shelter.db.ShelterDataAccess.DB_CONNECTION;

public class DogSelectDataAccessImpl implements DogSelectDataAccess
{
    @Override
    public Dog getDogByStatus(String dogStatus) {
        String currentSelect = "SELECT * FROM DOGS WHERE STATUS =" + dogStatus;

        try (
                Connection connection = DriverManager.getConnection(DB_CONNECTION);
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(currentSelect);

            while (resultSet.next()) {
                Dog dog = new Dog(resultSet.getInt(1), resultSet.getString(2));
                return dog;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Dog getDogById(final int dogId)
    {
        String currentSelect = "SELECT * FROM DOGS WHERE ID =" + dogId;

        try (
                Connection connection = DriverManager.getConnection(DB_CONNECTION);
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(currentSelect);

            while (resultSet.next()) {
                Dog dog = new Dog(resultSet.getInt(1), resultSet.getString(2));
                return dog;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Dog getCountByStatus(String dogStatus)
    {
        String currentSelect = "SELECT COUNT(1) FROM DOGS WHERE STATUS =" + dogStatus;
        try (
                Connection connection = DriverManager.getConnection(DB_CONNECTION);
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(currentSelect);

            while (resultSet.next()) {
                Dog dog = new Dog(resultSet.getInt(1), resultSet.getString(2));
                return dog;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

}
