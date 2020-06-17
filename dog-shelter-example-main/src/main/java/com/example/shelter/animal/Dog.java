package com.example.shelter.animal;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Important class
 */
public class Dog
{
    public String name = "Sharic";
    public LocalDateTime arrivalDate = LocalDateTime.now();
    public DogStatus dogStatus;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", dogStatus='" + dogStatus + '\'' +
                '}';
    }
}

