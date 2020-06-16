package com.example.shelter.animal;

import com.example.shelter.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Important class
 */
public class Dog
{
    public String name = "Sharic";
    public LocalDateTime date;
    public Status status;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
