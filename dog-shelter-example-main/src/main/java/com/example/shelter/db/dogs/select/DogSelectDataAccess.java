package com.example.shelter.db.dogs.select;

import com.example.shelter.animal.Dog;

import java.util.List;

public interface DogSelectDataAccess
{
    Dog getDogById(int dogId);
    List<Dog> getDogByStatus (String dogStatus);
    int getCountByStatus (String dogStatus);
}
