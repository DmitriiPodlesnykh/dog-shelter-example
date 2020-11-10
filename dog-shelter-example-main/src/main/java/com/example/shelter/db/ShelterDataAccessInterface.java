package com.example.shelter.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.shelter.animal.Dog;

public interface ShelterDataAccessInterface {
    int getCountDogs();

    String getDogNameById(int id) throws SQLException;

    /**
     * @return имена всех собак
     */
    ArrayList<String> getAllDogNames();

    /**
     * @return уникальные имена собак
     */
    Set<String> getUniqueDogNames();

    /**
     * @return список всех собак
     */
    List<Dog> getAllDogs();
}
