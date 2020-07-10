package com.example.shelter.db.dogs.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.example.shelter.animal.DogStatus;
import com.example.shelter.db.ShelterDataAccess;

public class DogUpdateDataAccessImpl implements DogUpdateDataAccess
{
    private static final String UPDATE_DOG_STATUS_BY_ID = "UPDATE DOGS SET status = ? WHERE ID = ?";

    @Override
    public void replaceDogStatusById(final int dogId, final DogStatus status)
    {
        try (Connection connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
                        PreparedStatement statement = connection.prepareStatement(UPDATE_DOG_STATUS_BY_ID);)
        {
            String statusString = status.name();
            statement.setString(1, statusString);

            statement.setInt(2, dogId);

            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void replaceDogStatusByName(final String name, final DogStatus status)
    {

    }

    @Override
    public void dischargeAllDogsBeforeDate(final LocalDate lastDate)
    {

    }
}
