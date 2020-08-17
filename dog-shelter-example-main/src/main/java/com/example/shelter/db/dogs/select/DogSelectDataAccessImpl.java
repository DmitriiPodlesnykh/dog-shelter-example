package com.example.shelter.db.dogs.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.shelter.animal.Dog;
import com.example.shelter.animal.DogStatus;

import static com.example.shelter.db.ShelterDataAccess.DB_CONNECTION;

public class DogSelectDataAccessImpl implements DogSelectDataAccess
{
    @Override
    public List<Dog> getDogByStatus(String dogStatus) {
        String currentSelect = "SELECT * FROM DOGS WHERE STATUS = upper(?)";
        List<Dog> result = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(DB_CONNECTION);
                PreparedStatement statement = connection.prepareStatement(currentSelect);
        ) {
            statement.setString(1, dogStatus);
            //System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Dog dog = new Dog(resultSet.getInt(1), resultSet.getString("NAME"));
                dog.dogStatus = DogStatus.valueOf(resultSet.getString("status"));
                dog.visitTime = resultSet.getTimestamp(3).toLocalDateTime();
                result.add(dog);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return result;
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
    public int getCountByStatus(String dogStatus)
    {
        String currentSelect = "SELECT COUNT(1) FROM DOGS WHERE STATUS = upper(?)";
        int countByStatus = 0;
        try (
                Connection connection = DriverManager.getConnection(DB_CONNECTION);
                PreparedStatement statement = connection.prepareStatement(currentSelect);
        ) {
            statement.setString(1, dogStatus);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                countByStatus = resultSet.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return countByStatus;
    }

    @Override
    public ArrayList<Dog> getDogByIds(final Collection<Integer> dogIds)
    {

        while(dogIds.iterator().hasNext())
        {
            ////////
            dogIds.iterator().next();
        }

        ArrayList<Dog> dogs = new ArrayList<>();
        for (Integer id : dogIds)
        {
            Dog dog = getDogById(id);
            dogs.add(dog);
        }

        if (dogs.isEmpty())
        {
            System.out.println("пустота");
        }
        return dogs;
    }
}
