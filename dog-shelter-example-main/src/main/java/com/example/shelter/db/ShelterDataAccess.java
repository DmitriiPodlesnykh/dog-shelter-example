package com.example.shelter.db;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.example.shelter.animal.Dog;

/**
 * Взаимодействие с БД
 */
public class ShelterDataAccess
{
    private static final String DB_CONNECTION
            = "jdbc:postgresql://ec2-54-247-78-30.eu-west-1.compute.amazonaws.com:5432/d91lfd343lpk2a?sslmode=require&user=xgelkpgtivsuvf&password=facd5537e5c673703e283c3a3728b73da206fbb123cef8bf310d2bee7d7c6202";

    public static int getCountDogs()
    {
        int count = 0;
        try
        {
            DriverManager.getConnection(DB_CONNECTION);
            Connection connection = DriverManager.getConnection(DB_CONNECTION);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select COUNT(1) from DOGS");

            while (resultSet.next())
            {
                count = resultSet.getInt(1);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return count;
    }

    public static String getDogNameById(int id)
    {
        String currentSelect = "SELECT NAME FROM DOGS WHERE ID =" + id;
        String resultName = "";
        try
        {
            Connection connection = DriverManager.getConnection(DB_CONNECTION);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(currentSelect);

            while (resultSet.next())
            {
                resultName = resultSet.getString(1);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultName;
    }

    /**
     * @return имена всех собак
     */
    public static List<String> getAllDogNames()
    {
        return new ArrayList<>();
    }

    /**
     * @return уникальные имена собак
     */
    public static Set<String> getUniqueDogNames()
    {
        return new HashSet<>();
    }

    /**
     * @return список всех собак
     */
    public static List<Dog> getAllDogs()
    {
        return new ArrayList<>();
    }
}
