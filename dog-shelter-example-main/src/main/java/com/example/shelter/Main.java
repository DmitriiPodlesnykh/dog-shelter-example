package com.example.shelter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.shelter.animal.Dog;
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
        String string2;
        String string3;

        while (!"exit".equals(string))
        {
            System.out.println("Enter dog new name:");
            string = in.nextLine();

            Dog newDog = new Dog();
            newDog.name = string;

            System.out.println("Enter appearance date (yyyy-mm-ddThh:mm:ss): ");
            string2 = in.nextLine();
            if(!string2.equals("")){
                newDog.date = LocalDateTime.parse(string2);
            } else newDog.date = LocalDateTime.now();

            System.out.println("Enter status (ADMITTED/NOT_ADMITTED/DISCHARGED: ");
            string3 = in.nextLine();
            if (!string3.equals("")){
                newDog.status = Status.valueOf(string3);
            } else newDog.status = Status.ADMITTED;

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
        String string2;
        String string3;

        while (!"exit".equals(string))
        {
            System.out.println("Enter dog new name:");
            string = in.nextLine();
            Dog newDog = new Dog();
            newDog.name = string;

            System.out.println("Enter appearance date (yyyy-mm-ddThh:mm:ss): ");
            string2 = in.nextLine();
            if(!string2.equals("")){
                newDog.date = LocalDateTime.parse(string2);
            } else newDog.date = LocalDateTime.now();

            System.out.println("Enter status (ADMITTED/NOT_ADMITTED/DISCHARGED: ");
            string3 = in.nextLine();
            if (!string3.equals("")){
                newDog.status = Status.valueOf(string3);
            } else newDog.status = Status.ADMITTED;

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
