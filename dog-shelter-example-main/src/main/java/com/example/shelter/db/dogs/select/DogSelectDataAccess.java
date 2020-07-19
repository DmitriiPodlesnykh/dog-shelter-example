package com.example.shelter.db.dogs.select;

import com.example.shelter.animal.Dog;

public interface DogSelectDataAccess
{
    Dog getDogById(int dogId);
}
