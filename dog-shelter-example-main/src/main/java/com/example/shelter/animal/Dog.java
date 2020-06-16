package com.example.shelter.animal;

import java.time.LocalDateTime;

/**
 * Important class
 */
public class Dog
{
    public String name = "Sharic";
    public LocalDateTime arrivalDateTime = LocalDateTime.now();
    public Status status = Status.ACCEPTED;


    @Override
    public String toString()
    {
        return "Dog{" +
                "name='" + name + '\'' +
                "arrivalDateTime='" + arrivalDateTime + '\'' +
                "status='" + status + '\'' +
                '}';
    }

}
