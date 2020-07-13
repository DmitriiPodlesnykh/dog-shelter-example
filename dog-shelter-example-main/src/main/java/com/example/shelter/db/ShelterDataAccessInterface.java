package com.example.shelter.db;

import com.example.shelter.animal.Dog;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ShelterDataAccessInterface {
    int getCountDogs();

    String getDogNameById(int id);


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
