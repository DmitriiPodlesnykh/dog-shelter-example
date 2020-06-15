package com.example.shelter.animal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Important class
 */
public class Dog
{
    public String name = "Sharic";
    public LocalDate admissionDate;
    public String status;


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", admissionDate=" + admissionDate +
                ", status='" + status + '\'' +
                '}';
    }
}

