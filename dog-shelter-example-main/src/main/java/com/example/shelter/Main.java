package com.example.shelter;

import java.time.LocalDate;
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
import com.example.shelter.db.dogs.update.DogUpdateDataAccessImplByNL;

public class Main {

    private static DogInsertDataAccessInterface dogInsertDataAccess = new DogInsertDataAccess();

    private static ShelterDataAccessInterface shelterDataAccess = new ShelterDataAccess();

    private static DogUpdateDataAccess dogUpdateDataAccess = new DogUpdateDataAccessImplByNL();

    public static void main(String... args) {
        dogUpdateDataAccess.replaceDogStatusById(99, DogStatus.ADMITTED);
        dogUpdateDataAccess.replaceDogStatusByName("Shadow", DogStatus.NOT_ADMITTED);
        
        LocalDate date = LocalDate.of(1980,12,24);
        dogUpdateDataAccess.dischargeAllDogsBeforeDate(date);

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
