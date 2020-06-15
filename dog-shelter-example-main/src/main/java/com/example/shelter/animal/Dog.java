package com.example.shelter.animal;

import java.time.LocalDateTime;

/**
 * Important class
 */
public class Dog
{
    public String name = "Sharic";
    //public LocalDateTime visitTime = LocalDateTime.now();
    public DogStatus dogStatus = DogStatus.ADMITTED;


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", dogStatus=" + dogStatus +
                '}';
    }
}
