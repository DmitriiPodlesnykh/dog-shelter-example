package com.example.shelter.db;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import com.example.shelter.animal.Dog;
import com.example.shelter.animal.DogStatus;

public class DogInsertDataAccess implements DogInsertDataAccessInterface
{
    private static final String INSERT_DOG_QUERY = "insert into dogs (name,status,visit_time) values (?,?,?);";

    public void addNewDogByName(String name)
    {
        Connection connection = null;
        Statement statement = null;
        try (
                Connection connection1 = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into dogs (name) values (?);"))
        {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                statement.close();
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }


    /**
     * Добавить всех собак из коллекции в БД
     * <p>
     * --@param dogs собаки
     */
    public void addNewDog(Dog dog)
    {
        try (
                Connection connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOG_QUERY)
        )
        {

            preparedStatement.setString(1, dog.name);
            preparedStatement.setString(2, dog.dogStatus.name());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(dog.visitTime));
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Добавить всех собак из коллекции в БД
     *
     * @param dogs собаки
     */
    public void addNewDogs(List<Dog> dogs)
    {
        for (Dog dog : dogs)
        {
            addNewDog(dog);
        }
    }
}
