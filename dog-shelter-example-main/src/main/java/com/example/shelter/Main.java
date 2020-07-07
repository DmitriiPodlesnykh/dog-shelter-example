package com.example.shelter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import com.example.shelter.animal.CurrentDogStatus;
import com.example.shelter.animal.Dog;
import com.example.shelter.animal.DogTime;
import com.example.shelter.db.DogInsertDataAccess;
import com.example.shelter.db.ShelterDataAccess;


public class Main
{
    public static void main(String... args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Dog name: ");
        String string = in.nextLine();
        while (!"exit".equals(string))
        {
            System.out.println("Dog name: ");
            Dog newDog = new Dog();
            newDog.name=string;
            newDog.dogStatus = CurrentDogStatus.getStatus();
            try{
                newDog.visitTime= DogTime.dogAdmissionTime();
            }
            catch (Exception e){
                System.out.println("wrong format");
                newDog.visitTime= LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
            }
            //DogInsertDataAccess.addNewDog(string);
            DogInsertDataAccess. addNewDogs(newDog.name,newDog.dogStatus,newDog.visitTime);

        }

        System.out.println("Dog table size = "  + ShelterDataAccess.getCountDogs());
    }


}
