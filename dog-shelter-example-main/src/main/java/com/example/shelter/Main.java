package com.example.shelter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.shelter.animal.Dog;
import com.example.shelter.animal.Status;

import java.util.List;

public class Main
{
    public static void main(String... args)
    {
        System.out.println("Выберете сохранять к коллекцию(1) или в массив(2)?");
        Scanner in = new Scanner(System.in);
        int selectedCase = in.nextInt();
        if(selectedCase == 1)
        {
            caseWithArrayList();
        } else if (selectedCase == 2)
        {
            caseWithArray();
        } else
        {
            System.out.println("некорректный ввод. Пока");
        }
    }

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
            dogs[index] = newDog;
            index++;

            System.out.println("dog arrival date (e.g. 2012-12-12T10:00:30)");
            string = in.nextLine();
            if (string.length()>0) {
                newDog.arrivalDateTime = LocalDateTime.parse(string);
            }

            System.out.println("dog status (A/N/D)");
            string = in.nextLine();
            if (string.length()==1) {
                if ("A".equals(string)){
                    newDog.status = Status.ACCEPTED;
                }
                else if ("N".equals(string)){
                    newDog.status = Status.NOTACCEPTED;
                }
                else if ("D".equals(string)){
                    newDog.status = Status.DISCHARGED;
                }
                else
                    System.out.println("Entry is wrong. Default used.");
            }

            System.out.println("Type 'exit' to complete or any to contiue");
            string = in.nextLine();
        }

        //вывод результата на экран
        for (final Dog dog : dogs)
        {
            System.out.println(dog);
        }
    }
}
