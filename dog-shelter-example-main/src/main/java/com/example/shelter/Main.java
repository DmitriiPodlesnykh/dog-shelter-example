package com.example.shelter;

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
        String stringAD = null;
        LocalDateTime localDateTime = LocalDateTime.now();

        while (!"exit".equals(string)) {
            System.out.println("dog new name:");
            string = in.nextLine();
            Dog newDog = new Dog();
            newDog.name = string;

            if(!"exit".equals(string)) {
                System.out.println("dog admission time stamp (in format 'yyyy-MM-ddThh:mm' - e.g. 2020-06-13T21:41):");
                stringAD = in.nextLine();
                if (!stringAD.equals("")) {
                    localDateTime = LocalDateTime.parse(stringAD);
                }
            }
            newDog.admissionDate = localDateTime;
        dogs.add(newDog);
    }
            System.out.println(dogs);
}

        private static void caseWithArray ()
        {
            Scanner in = new Scanner(System.in);

            Dog[] dogs = new Dog[5];
            int index = 0;
            String string = null;
            while (!"exit".equals(string)) {
                System.out.println("dog new name:");
                string = in.nextLine();
                Dog newDog = new Dog();
                newDog.name = string;
                dogs[index] = newDog;
                index++;
            }

            //вывод результата на экран
            for (final Dog dog : dogs) {
                System.out.println(dog);
            }
        }
    }
