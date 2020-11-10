package com.example.shelter.service;

import java.time.LocalDate;

import com.example.shelter.animal.Animal;
import com.example.shelter.animal.Dog;
import com.example.shelter.animal.DogStatus;

public class AuditService
{
    public boolean isActive(Animal animal)
    {
        if (animal == null)
        {
            return false;
        }
        if (!(animal instanceof Dog))
        {
            return false;
        }
        Dog dog = (Dog)animal;

        if (dog.dogStatus == DogStatus.NOT_ADMITTED)
        {
            return false;
        }

        if (dog.name == null)
        {
            return false;
        }
        if (dog.id == 0)
        {
            return false;
        }
        if (!dog.isExist())
        {
            return false;
        }
        if(dog.id < 1000000)
        {
            return false;
        }
        return !dog.visitTime.toLocalDate().isBefore(LocalDate.of(2000, 1, 1));
    }
}
