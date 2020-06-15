package com.example.shelter.animal;

import com.example.shelter.Status;

import java.time.LocalDateTime;

/**
 * Important class
 */
public class Dog
{
    public String name = "Sharic";
    public LocalDateTime localDateTime;
    public String dogStatus;


    @Override
    public String toString()
    {
        return "Dog{" +
                "name ='" + name + '\'' +
                " arrival date and time: '" + localDateTime + '\'' +
                " status: '" + dogStatus + '\'' +
                '}';

    }
}
