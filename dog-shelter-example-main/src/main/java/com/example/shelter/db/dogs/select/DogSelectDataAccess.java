package com.example.shelter.db.dogs.select;

import java.util.Collection;
import java.util.List;

import com.example.shelter.animal.Dog;

public interface DogSelectDataAccess
{
    Dog getDogById(int dogId);
    List<Dog> getDogByStatus (String dogStatus);
    int getCountByStatus (String dogStatus);

    List<Dog> getDogByIds(Collection<Integer> dogIds);
}
