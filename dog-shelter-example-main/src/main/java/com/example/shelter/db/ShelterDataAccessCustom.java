package com.example.shelter.db;

import com.example.shelter.animal.Dog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ShelterDataAccessCustom implements ShelterDataAccessInterface {

    @Override
    public int getCountDogs() {
        int count = 0;
        Connection connection = null;
        Statement statement = null;
        //try-catch-finally example
        try {
            connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select COUNT(1) from DOGS");

            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }

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
        return count;
    }

    @Override
    public String getDogNameById(int id) {
        return null;
    }

    @Override
    public ArrayList<String> getAllDogNames() {
        return null;
    }

    @Override
    public Set<String> getUniqueDogNames() {
        return null;
    }

    @Override
    public List<Dog> getAllDogs() {
        return null;
    }
}
