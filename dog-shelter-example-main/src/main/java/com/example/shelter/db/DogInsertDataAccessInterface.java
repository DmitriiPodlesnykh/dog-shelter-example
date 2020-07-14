package com.example.shelter.db;
import java.util.List;

import com.example.shelter.animal.Dog;

public interface DogInsertDataAccessInterface
{
    void addNewDogByName(String name);

    /**
     * Добавить всех собак из коллекции в БД
     * <p>
     * --@param dogs собаки
     */
    void addNewDog(Dog dog);

    void addNewDogs(List<Dog> dogs);
}
