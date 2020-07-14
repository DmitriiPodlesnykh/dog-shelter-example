package com.example.shelter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.shelter.animal.CurrentDogStatus;
import com.example.shelter.animal.Dog;
import com.example.shelter.animal.DogStatus;
import com.example.shelter.animal.DogTime;
import com.example.shelter.db.*;
import com.example.shelter.db.dogs.update.DogUpdateDataAccess;
import com.example.shelter.db.dogs.update.DogUpdateDataAccessImpl;

public class Main {

    private static DogInsertDataAccessInterface dogInsertDataAccess = new DogInsertDataAccess();

    private static ShelterDataAccessInterface shelterDataAccess = new ShelterDataAccess();

    private static DogUpdateDataAccess dogUpdateDataAccess = new DogUpdateDataAccessImpl();

    public static void main(String... args) {
        dogUpdateDataAccess.replaceDogStatusById(2, DogStatus.DISCHARGED);

        Scanner in = new Scanner(System.in);
        String string = null;
        List<Dog> listDog = new ArrayList<>();
        while (!"exit".equals(string)) {
            System.out.println("Dog name: ");
            string = in.nextLine();
            Dog newDog = new Dog();
            newDog.name = string;
            newDog.dogStatus = CurrentDogStatus.getStatus();
            try {
                newDog.visitTime = DogTime.dogAdmissionTime();
            } catch (Exception e) {
                System.out.println("wrong format");
                newDog.visitTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
            }
            listDog.add(newDog);


            dogInsertDataAccess.addNewDogs(listDog);


        }
        System.out.println("Dog table size = " + shelterDataAccess.getCountDogs());
    }


}
