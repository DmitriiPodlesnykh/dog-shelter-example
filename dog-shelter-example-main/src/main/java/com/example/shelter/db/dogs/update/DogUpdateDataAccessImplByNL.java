package com.example.shelter.db.dogs.update;

import com.example.shelter.animal.DogStatus;
import com.example.shelter.db.ShelterDataAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DogUpdateDataAccessImplByNL implements DogUpdateDataAccess {
    private static final String UPDATE_DOG_STATUS_BY_ID = "UPDATE DOGS SET status = ? WHERE ID = ?";
    private static final String UPDATE_DOG_STATUS_BY_NAME = "UPDATE DOGS SET status = ? WHERE NAME = ?";
    private static final String SET_DISCHARGE_DOG_STATUS_BY_DATE = "UPDATE DOGS SET status = ? WHERE VISIT_TIME < ?";

    @Override
    public void replaceDogStatusById(int dogId, DogStatus status) {
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
    public void replaceDogStatusByName(String name, DogStatus status) {
        try (Connection connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
             PreparedStatement statement = connection.prepareStatement(UPDATE_DOG_STATUS_BY_NAME);)
        {
            String statusString = status.name();
            statement.setString(1, statusString);

            statement.setString(2, name);
            System.out.println(statement);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dischargeAllDogsBeforeDate(LocalDate lastDate) {
        try (Connection connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
             PreparedStatement statement = connection.prepareStatement(SET_DISCHARGE_DOG_STATUS_BY_DATE);)
        {
            statement.setString(1, DogStatus.DISCHARGED.name());

            statement.setDate(2, Date.valueOf(lastDate));
            //statement.setObject(2, lastDate);
            //System.out.println(statement);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
