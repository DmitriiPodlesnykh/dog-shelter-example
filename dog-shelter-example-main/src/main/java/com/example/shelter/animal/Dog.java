package com.example.shelter.animal;

import java.time.LocalDateTime;

/**
 * Important class
 */
public class Dog
{

    public String name = "Sharic";
    public LocalDateTime DogTime = LocalDateTime.now();
    public String DogStatus = "Принят";


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", time='" + DogTime + '\'' +
                ", status='" + DogStatus + '\'' +
                '}';
    }
}
