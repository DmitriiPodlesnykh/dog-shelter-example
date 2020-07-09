package com.example.shelter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.shelter.animal.CurrentDogStatus;
import com.example.shelter.animal.Dog;
import com.example.shelter.animal.DogTime;
import com.example.shelter.db.*;


public class Main {

    private static DogInsertDataAccessInterface dogInsertDataAccess = new DogInsertDataAccess();


    private static ShelterDataAccessInterface shelterDataAccess = new ShelterDataAccessCustom();



    public static void main(String... args) {
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
