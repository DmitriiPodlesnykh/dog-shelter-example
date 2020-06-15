package com.example.shelter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.shelter.animal.Dog;
import java.util.List;

public class Main {
    public static void main(String... args) {
        System.out.println("Выберете сохранять к коллекцию(1) или в массив(2)?");
        Scanner in = new Scanner(System.in);
        int selectedCase = in.nextInt();

        if (selectedCase == 1) {
            caseWithArrayList();
        } else if (selectedCase == 2) {
            caseWithArray();
        } else {
            System.out.println("некорректный ввод. Пока");

        }

    }

    private static void caseWithArrayList() {
        Scanner in = new Scanner(System.in);

        List<Dog> dogs = new ArrayList<>();

        String string = null;

        while (!"exit".equals(string)) {
            System.out.println("dog new name:");
            string = in.nextLine();

            if (!"exit".equals(string)) {
                Dog newDog = new Dog();
                newDog.name = string;

                System.out.println("Enter the date of admission in the YYYY-MM-DD format");
                String admissionDate = in.nextLine();
                if (admissionDate.equals("")) {
                    LocalDate localDate = LocalDate.now();
                    newDog.admissionDate = localDate;
                } else {
                    LocalDate convertToTimeDate = LocalDate.parse(admissionDate);
                    newDog.admissionDate = convertToTimeDate;
                }

                dogs.add(newDog);
            }
        }

        System.out.println(dogs);
    }

    private static <Set> void caseWithArray() {
        Scanner in = new Scanner(System.in);

        Dog[] dogs = new Dog[5];
        int index = 0;
        String string = null;
        while (!"exit".equals(string)) {
            System.out.println("dog new name:");
            string = in.nextLine();

            if (!"exit".equals(string)) {
                Dog newDog = new Dog();
                newDog.name = string;

                System.out.println("Enter the date of admission in the YYYY-MM-DD format");
                String admissionDate = in.nextLine();
                if (admissionDate.equals("")) {
                    LocalDate localDate = LocalDate.now();
                    newDog.admissionDate = localDate;
                } else {
                    LocalDate convertToTimeDate = LocalDate.parse(admissionDate);
                    newDog.admissionDate = convertToTimeDate;
                }

                dogs[index] = newDog;
                index++;

            }

            //вывод результата на экран
            for (final Dog dog : dogs) {
                System.out.println(dog);
            }

        }
    }
}
