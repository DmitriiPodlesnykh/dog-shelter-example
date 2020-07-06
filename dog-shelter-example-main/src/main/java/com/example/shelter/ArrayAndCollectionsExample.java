package com.example.shelter;

import com.example.shelter.animal.CurrentDogStatus;
import com.example.shelter.animal.Dog;
import com.example.shelter.animal.DogTime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayAndCollectionsExample {

    private static void caseWithArrayList()
    {
        Scanner in = new Scanner(System.in);

        List<Dog> dogs = new ArrayList<>();

        String string = null;

        while (!"exit".equals(string))
        {
            System.out.println("dog new name:");
            string = in.nextLine();
            Dog newDog = new Dog();
            newDog.name = string;
            newDog.dogStatus = CurrentDogStatus.getStatus();
            try
            {
                newDog.visitTime = DogTime.dogAdmissionTime();
            }
            catch (Exception e)
            {
                System.out.println("wrong date format");
                newDog.visitTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
            }
            dogs.add(newDog);
        }

        System.out.println(dogs);
    }

    private static void caseWithArray()
    {
        Scanner in = new Scanner(System.in);

        Dog[] dogs = new Dog[5];
        int index = 0;
        String string = null;
        while (!"exit".equals(string))
        {
            System.out.println("dog new name:");
            string = in.nextLine();
            Dog newDog = new Dog();
            newDog.name = string;
            newDog.dogStatus = CurrentDogStatus.getStatus();
            try
            {
                newDog.visitTime = DogTime.dogAdmissionTime();
            }
            catch (Exception e)
            {
                System.out.println("wrong date format");
                newDog.visitTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
            }
            dogs[index] = newDog;
            index++;
        }

        //вывод результата на экран
        for (final Dog dog : dogs)
        {
            System.out.println(dog);
        }
    }
}
