package com.example.shelter.db.dogs.update;

import com.example.shelter.animal.DogStatus;
import com.example.shelter.db.ShelterDataAccess;

import java.sql.*;
import java.time.LocalDate;
import java.time.Year;

public class DogUpdateDataAccessByValeriia implements DogUpdateDataAccess {

    private static final String UPDATE_DOG_STATUS_BY_ID = "UPDATE DOGS SET status = ? WHERE ID = ?";
    private static final String UPDATE_DOG_STATUS_BY_NAME = "UPDATE DOGS SET status = ? WHERE NAME = ?";
    private static final String UPDATE_DOG_STATUS_BY_DATE = "UPDATE DOGS SET status = ? where visit_time < ?;";

    @Override
    public void replaceDogStatusById(int dogId, DogStatus status) {
        try (Connection connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
             PreparedStatement statement = connection.prepareStatement(UPDATE_DOG_STATUS_BY_ID);) {
            String statusString = status.name();
            statement.setString(1, statusString);

            statement.setInt(2, dogId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void replaceDogStatusByName(String name, DogStatus status) {
        try (Connection connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
             PreparedStatement statement = connection.prepareStatement(UPDATE_DOG_STATUS_BY_NAME)) {
            String dogStatusString = status.name();
            statement.setString(1, dogStatusString);
            statement.setString(2, name);

            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dischargeAllDogsBeforeDate(LocalDate lastDate) {
        try (Connection connection = DriverManager.getConnection(ShelterDataAccess.DB_CONNECTION);
             PreparedStatement statement = connection.prepareStatement(UPDATE_DOG_STATUS_BY_DATE)) {
            DogStatus dogStatusString = DogStatus.DISCHARGED;
            statement.setString(1, dogStatusString.name());
            LocalDate dogDate = lastDate;
            statement.setDate(2, Date.valueOf(dogDate));

            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
