package com.example.shelter.animal;

import java.time.LocalDate;

/**
 * Important class
 */
public class Dog
{
    public String name = "Sharic";
    public LocalDate arrivalDate = LocalDate.now();
    public String dogStatus;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", dogStatus='" + dogStatus + '\'' +
                '}';
    }
}

