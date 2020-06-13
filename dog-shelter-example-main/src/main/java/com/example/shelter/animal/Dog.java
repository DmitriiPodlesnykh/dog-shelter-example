package com.example.shelter.animal;

import java.time.LocalDateTime;

/**
 * Important class
 */
public class Dog
{
    public String name = "Sharic";
    public LocalDateTime admissionDate = LocalDateTime.now();
    public String status = "admitted/not admitted/ discharged";

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", admissionDate=" + admissionDate +
                ", status='" + status + '\'' +
                '}';
    }
}
